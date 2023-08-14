package com.cfg;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.invoicedao.CustomerDao;

@Configuration
@ComponentScan({"com.MVC","com.invoicedao"})
public class AppConfig {

	@Bean
	public DataSource dataSource(){
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/Invoice");
		datasource.setUsername("saravana");
		datasource.setPassword("sethupathi790");

		return datasource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public CustomerDao customerdao() {
		CustomerDao  dao = new CustomerDao();
		dao.setJdbcTemplate(jdbcTemplate());
		return dao;
	}

}
