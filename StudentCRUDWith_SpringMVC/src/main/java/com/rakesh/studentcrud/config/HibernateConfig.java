package com.rakesh.studentcrud.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.rakesh.studentcrud.model"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfig {
  
	@Autowired
	private Environment env;
	
	@Bean("ds")
	public DataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	} 
	
	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(ds);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.rakesh.studentcrud.model");
		return builder.buildSessionFactory();
		
	}

	private Properties getHibernateProperties() {
       Properties p=new Properties();
       p.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
       p.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
       p.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
       p.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return p;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		HibernateTransactionManager txManager= new HibernateTransactionManager(sf);
		return txManager;
		
	}
}
