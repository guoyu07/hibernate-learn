package com.shimh.batch;

import java.util.stream.IntStream;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.junit.Test;

import com.shimh.BaseTest;

public class BatchDemoTest extends BaseTest{
	
	@Test
	public void noBatch(){
		IntStream.range(0, 101).forEach(i -> {
			BatchDemo demo  = new BatchDemo();
			demo.setName(Integer.toString(i));
			session.persist(demo);
		});
	}
	
	@Test
	public void batch(){
		//session.setJdbcBatchSize(20);
		IntStream.range(0, 101).forEach(i -> {
			BatchDemo demo  = new BatchDemo();
			demo.setId(i);
			demo.setName(Integer.toString(i));
			session.persist(demo);
			if ( i > 0 && i % 20 == 0 ) {
				session.flush();
				session.clear();
	        }
		});
	}
	
	/*
	 * 当你检索和更新数据，并定期flush() clear()会话。
	 * 此外，使用方法scroll()利用服务器端游标返回多行数据的查询。
	 */
	@Test
	public void scrollbBatch(){
		ScrollableResults scrollableResults = session.createQuery( "from BatchDemo" )
			        .setCacheMode( CacheMode.IGNORE )
			        .scroll( ScrollMode.FORWARD_ONLY );
		int count = 0;
		int batchSize = 20;
	    while ( scrollableResults.next() ) {
	    	BatchDemo demo = (BatchDemo) scrollableResults.get( 0 );
	    	
	    	//一些业务处理
	    	demo.setName(demo.getName() + "update");
	    	
	        if ( count++ % batchSize == 0 ) {
				session.flush();
				session.clear();
	        }
	    }
	    if (scrollableResults != null) {
	        scrollableResults.close();
	    }
	}
}
