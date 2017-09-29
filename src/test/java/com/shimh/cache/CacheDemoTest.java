package com.shimh.cache;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.junit.Test;

import com.shimh.BaseTest;

/*
 * 二级缓存  整合ehcache
 * 
 *  1 hibernate.cache.use_second_level_cache = true 开启二级缓存，默认也是true
 *  2 hibernate.cache.use_query_cache = true 开启查询缓存 默认false 二级缓存只缓存实体和collection
 *   	若想缓存查询结果（hql语句等），则可以设置
 *   	session.setCacheable(true)
 * 
 * 	3 配置  hibernate.cache.region.factory_class = 
 * 		若有多个SessionFactory：
 * 				org.hibernate.cache.ehcache.EhCacheRegionFactory  每个都有一个CacheManager 
 * 				org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory 多个共享一个CacheManager 
 *  
 *  4 配置缓存并发策略：
 *  	1 全局：hibernate.cache.default_cache_concurrency_strategy = 
 * 				read-only
 * 				read-write
 * 				nonstrict-read-write
 * 				transactional  ehcache不支持
 *      2 @Cache：实体上定义   推荐   若是继承：则要定义到基类上，不可子类
 * 
 */


public class CacheDemoTest extends BaseTest{
	
	@Test
	public void add() throws Exception{
		Date now = new Date();
		
		CacheDemo1 demo1 = new CacheDemo1();
		demo1.setName("demo12");
		demo1.setTime(now);
		
		CacheDemo2 demo2 = new CacheDemo2();
		demo2.setName("demo22");
		demo2.setTime(now);
		demo2.setDemo1(demo1);
		
		CacheDemo3 demo3 = new CacheDemo3();
		demo3.setName("demo32");
		demo3.setTime(now);
		
		session.save(demo1);
		session.save(demo2);
		session.save(demo3);
	}
	
	/*
	 * 只发出一条SQL语句
	 */
	@Test
	public void test1() throws Exception{
		
		CacheDemo1 demo1 = session.get(CacheDemo1.class, 1);
		//List<CacheDemo1> demo1 = session.createQuery("from CacheDemo1").list();
		System.out.println(demo1);
		System.out.println("-------");
		
		Session session2 = sessionFactory.openSession();
		CacheDemo1 demo1new = session2.get(CacheDemo1.class, 1);
		System.out.println(demo1new);
		System.out.println("-------");
	}
	/*
	 * 发出2条SQL语句，CacheDemo3没有@Cache
	 */
	@Test
	public void test2() throws Exception{
		
		CacheDemo3 demo3 = session.get(CacheDemo3.class, 1);
		System.out.println(demo3);
		System.out.println("-------");
		
		Session session2 = sessionFactory.openSession();
		CacheDemo3 demo3new = session2.get(CacheDemo3.class, 1);
		System.out.println(demo3new);
		
	}
	/*
	 * 	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
		@OneToMany(mappedBy = "demo1",fetch = FetchType.LAZY)
		private List<CacheDemo2> demo2s = new ArrayList<CacheDemo2>();
	 * 
	 * 集合缓存：元素为值类型（basic或embeddables）时缓存其值。
	 * 				为实体时只缓存实体的标识，如id
	 * 
	 * 所以要想集合缓存，则元素CacheDemo2也要缓存 即
	 * 						@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
							@Table
							@Entity
							public class CacheDemo2 {}
		只发出一条SQL语句
	 * 
	 */
	@Test
	public void test3() throws Exception{
		
		CacheDemo1 demo1 = session.get(CacheDemo1.class, 1);
		for(CacheDemo2 d:demo1.getDemo2s()){
			System.out.println(d.getName());
		}
		System.out.println("-------");
		
		Session session2 = sessionFactory.openSession();
		CacheDemo1 demo1new = session2.get(CacheDemo1.class, 1);
		for(CacheDemo2 d:demo1new.getDemo2s()){
			System.out.println(d.getName());
		}
		System.out.println("-------");
		
	}
	/*
	 * 查询缓存  手动：session.setCacheable(true) 开启
	 * 
	 * 查询缓存不缓存缓存中实际实体的状态；它只缓存标识符值和值类型的结果。
	 * 
	 * 发出一条SQL语句
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test4() throws Exception{
		
		List<CacheDemo1> demo1s = session.createQuery(
		    "select p " +
		    "from CacheDemo1 p " +
		    "where p.name = :name")
		.setParameter( "name", "demo12")
		.setCacheable(true)
		.list();
		System.out.println(demo1s);

		System.out.println("-------");
		
		Session session2 = sessionFactory.openSession();
		List<CacheDemo1> demo1snew = session2.createQuery(
			    "select p " +
			    "from CacheDemo1 p " +
			    "where p.name = :name")
			.setParameter( "name", "demo12")
			.setCacheable(true)
			.list();
			System.out.println(demo1snew);
		
	}
	/*
	 * 清空缓存  2条SQL语句
	 */
	@Test
	public void test5() throws Exception{
		CacheDemo1 demo1 = session.get(CacheDemo1.class, 1);
		System.out.println(demo1);
		System.out.println("-------");
		
		sessionFactory.getCache().evictAll();
		
		Session session2 = sessionFactory.openSession();
		CacheDemo1 demo1new = session2.get(CacheDemo1.class, 1);
		System.out.println(demo1new);
		
	}
	/*
	 * 缓存统计
	 */
	@Test
	public void test6() throws Exception{
		CacheDemo1 demo1 = session.get(CacheDemo1.class, 1);
		System.out.println(demo1);
		
		
		Statistics statistics = session.getSessionFactory().getStatistics();
		/*SecondLevelCacheStatistics secondLevelCacheStatistics =
		        statistics.getSecondLevelCacheStatistics(regionName)*/;
		System.out.println(statistics.getSecondLevelCachePutCount());
		
		System.out.println("-------");
		
		Session session2 = sessionFactory.openSession();
		CacheDemo1 demo1new = session2.get(CacheDemo1.class, 1);
		System.out.println(demo1new);
		
	}
	
}
