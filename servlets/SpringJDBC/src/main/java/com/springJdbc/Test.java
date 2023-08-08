package com.springJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Appconfig.class);
		
		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		
		int status = dao.saveEmployee(new Employee(1, "Amith", 50000));
		
		System.out.println(status);

	}

}
