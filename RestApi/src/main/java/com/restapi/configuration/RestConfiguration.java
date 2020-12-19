package com.restapi.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.restapi.*")
@EnableWebMvc
@PropertySource("classpath:DataBase.properties")
@EnableTransactionManagement
public class RestConfiguration {

	private final String DRIVER="db.driver";
	private final String URL="db.url";
	private final String USER_NAME="db.userName";
	private final String PASSWORD="db.password";
	private final String DIALECT="db.hibenate.Dialect";
	private final String PACKAGE_SCAN="db.packageToScan";
	
	@Resource
	private Environment envoirnment;
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(envoirnment.getRequiredProperty(DRIVER));
		driverManagerDataSource.setUrl(envoirnment.getRequiredProperty(URL));
		driverManagerDataSource.setUsername(envoirnment.getRequiredProperty(USER_NAME));
		driverManagerDataSource.setPassword(envoirnment.getRequiredProperty(PASSWORD));
		return driverManagerDataSource;
	}
	
	@Bean
	public Properties properties()
	{
		Properties properties=new Properties();
		properties.setProperty(DIALECT, envoirnment.getRequiredProperty(DIALECT));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessFactoryBean()
	{
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setPackagesToScan(envoirnment.getRequiredProperty(PACKAGE_SCAN));
		bean.setDataSource(dataSource());
		bean.setHibernateProperties(properties());
		return bean;
	}
	
	@Bean 
	public HibernateTransactionManager manager() {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessFactoryBean().getObject());
		return hibernateTransactionManager;
	}
}
