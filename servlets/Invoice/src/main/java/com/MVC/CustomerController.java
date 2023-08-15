package com.MVC;


import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoice.Customer;
import com.invoicedao.CustomerDao;


@Component
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDao customer;
	
	
	@RequestMapping("/customers")
	public JSONObject getCustomers(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject responseObject = new JSONObject();
			responseObject.put("Status",response.getStatus());
			responseObject.put("Message", customer.getCustomers());
			System.out.println(responseObject);
			PrintWriter out = response.getWriter();
			out.print(responseObject);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@RequestMapping("/customer")
	public JSONObject getCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			String customerId = request.getParameter("customer_id");
			JSONObject responseObject = new JSONObject();
			responseObject.put("Status",response.getStatus());
			responseObject.put("Message", customer.specificCustomer(customerId));
			System.out.println(responseObject);
			PrintWriter out = response.getWriter();
			out.print(responseObject);
			return responseObject;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping("/addcustomer")
	public void setCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String customerName = request.getParameter("customer_name");
			String customerMail = request.getParameter("customer_mail");
			String customerMobile = request.getParameter("customer_mobile");
			
			UUID uniqueKey = UUID.randomUUID();
			System.out.println (uniqueKey);
			 
			int num = customer.saveCustomer(new Customer(uniqueKey.toString(), customerName, customerMail, customerMobile));
			PrintWriter out = response.getWriter();
			out.print(num);
			System.out.println(num);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/editcustomer")
	public void editCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			String customerId = request.getParameter("customer_id");
			String customerName = request.getParameter("customer_name");
			String customerMail = request.getParameter("customer_mail");
			String customerMobile = request.getParameter("customer_mobile");
			 
			int num = customer.updateCustomer(new Customer(customerId, customerName, customerMail, customerMobile));
			PrintWriter out = response.getWriter();
			out.print(num);
			System.out.println(num);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/deletecustomer")
	public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			String customerId = request.getParameter("customer_id");
			customer.deleteCustomer(new Customer(customerId, null, null, null));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
