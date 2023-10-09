package com.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.dao", "com.controller", "com.fakerData" })
public class AppConfig {
	
}
