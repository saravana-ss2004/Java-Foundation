package com.invoicedao;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;


import com.invoice.Customer;


public class CustomerDao {
	
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public int saveCustomer(Customer customer) {
		try {
			String query = "insert into Customers values ('"+customer.getCustomerId()+"','"+customer.getCustomerName()+"','"+customer.getEmail()+"','"+customer.getMobileNumber()+"')";
			jdbcTemplate.update(query);
			return 1;
			
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	
	public JSONArray getCustomers() {
		try {
			String query = "select * from Customers";
			List<Customer> customers = jdbcTemplate.query(query, new CustomerRowMapper());
			
			JSONArray array = new JSONArray();
			for (Customer customer : customers) {
				JSONObject obj = new JSONObject();
				obj.put("id",customer.getCustomerId());
				obj.put("name",customer.getCustomerName());
				obj.put("mail",customer.getEmail());
				obj.put("mobilenumber",customer.getMobileNumber());
				array.put(obj);
			}
			
			return array;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	public int updateCustomer(Customer customer) {
		
		try {
			String query = "update Customers set customer_name='"+customer.getCustomerName()+"',e_mail='"+customer.getEmail()+"',mobile_number='"+customer.getMobileNumber()+"'where customer_id='"+customer.getCustomerId()+"'";
			jdbcTemplate.update(query);
			
			return 1;
		}
		catch(Exception e) {
			return 0;
		}
		
	}
	
	public int deleteCustomer(Customer customer) {
		String query = "delete from Customers where customer_id='"+customer.getCustomerId()+"'";
		return jdbcTemplate.update(query);
	}
	
	public JSONArray specificCustomer(String id) {
		String query = "select * from Customers where customer_id = '"+id+"'";
		
		List<Customer> customers = jdbcTemplate.query(query, new CustomerRowMapper());
		JSONArray array = new JSONArray();
		for (Customer customer : customers) {
			JSONObject obj = new JSONObject();
			obj.put("id",customer.getCustomerId());
			obj.put("name",customer.getCustomerName());
			obj.put("mail",customer.getEmail());
			obj.put("mobilenumber",customer.getMobileNumber());
			array.put(obj);
		}
		return array;
	}
		
}
