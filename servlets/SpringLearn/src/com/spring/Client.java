package com.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	public static void main(String[] args) {
		
		
		//bean factory create objects only when you request
		//Resource resource = new ClassPathResource("employeebean.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);
		
		//Employee e1 = (Employee) factory.getBean("emp1");  
		
		
		//Application context creates objects even though you don't request
		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
		Employee e2 = (Employee) context.getBean("emp1");
		
		BusinessLogic b= (BusinessLogic) context.getBean("logic");
		
		
		b.logic();
		
		//System.out.println(e2);
			
	}

}
