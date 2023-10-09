package com.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class CallForCrm extends HttpServlet{
	
	public void init() throws ServletException{
		CrmApi test = new CrmApi();
		test.executeJob();
		
	}
}
