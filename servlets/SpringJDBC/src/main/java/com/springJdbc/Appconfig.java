package com.springJdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.springJdbc")
public class Appconfig {

	@Bean
	public DataSource ds() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/Employee");
		dataSource.setUsername("saravana");
		dataSource.setPassword("sethupathi790");
		return dataSource;
	}

	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds());
        
        System.out.println(jdbcTemplate);
        return jdbcTemplate;
    }
	
	 @Bean
	    public EmployeeDao edao() {
	        EmployeeDao employeeDao = new EmployeeDao();
	        employeeDao.setJdbcTemplate(jdbcTemplate());
	        return employeeDao;
	    }
}
