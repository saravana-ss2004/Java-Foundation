package com.cfg;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		try {
			return new String[] {"/customers","/addcustomer","/deletecustomer","/customer","/addcustomer","/editcustomer","/products","/addproduct","/deleteproduct","/product","/editproduct","/invoices","/addinvoice","/deleteinvoice","/invoice","/editinvoice","/specifiedinvoice"};

		}catch(Exception e) {
			
			System.out.println(e);
		}
		return null;
	}
}
