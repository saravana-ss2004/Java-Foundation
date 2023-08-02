package com.spring;

import org.aopalliance.aop.Advice;

public class BusinessLogic implements Advice{
	

	public void logic() {
		System.out.println("actual business logic");
	}
	

}
