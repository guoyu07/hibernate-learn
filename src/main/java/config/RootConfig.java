package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
@EnableTransactionManagement
public class RootConfig {
	
    @Bean(initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
        dataSource.setUsername("root");
        dataSource.setPassword("analyse");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(2);   //定义初始连接数
        dataSource.setMinIdle(1);       //最小空闲
        dataSource.setMaxActive(20);    //定义最大连接数
        dataSource.setMaxWait(60000);   //最长等待时间

        dataSource.setTimeBetweenEvictionRunsMillis(60000);

        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return dataSource;
    }
	
	
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    	
    	LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    	factoryBean.setDataSource(dataSource);
    	
    	factoryBean.setPackagesToScan("com.shimh");
    	
    	Properties p = new Properties();
    	p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    	p.setProperty("hibernate.hbm2ddl.auto", "update");
    	p.setProperty("hibernate.show_sql", "true");
    	p.setProperty("hibernate.format_sql", "true");
    	p.setProperty("hibernate.jdbc.batch_size", "20");
    	p.setProperty("hibernate.cache.use_second_level_cache", "true");
    	p.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
    	p.setProperty("hibernate.cache.use_query_cache", "true");
    	
    	//p.setProperty("hibernate.current_session_context_class", "thread");
    	//hibernate.globally_quoted_identifiers = true  表的列名可以是关键字如：table, columns
    	factoryBean.setHibernateProperties(p);
        return factoryBean;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory);
        return manager;
    }
}
