package com.mnp.springmvcjdbc.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mnp.springmvcjdbc.dao.PersonDAO;
import com.mnp.springmvcjdbc.dao.PersonDAOImpl;

@Configuration
@ComponentScan(basePackages="com.mnp.springmvcjdbc.dao")
@EnableWebMvc
public class MvcConfiguration {
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("url");
		dataSource.setUsername("username");
		dataSource.setPassword("password");
		
		return dataSource;
	}
	
	@Bean
	public PersonDAO getPersonDAO(){
		return new PersonDAOImpl(getDataSource());
	}
}
