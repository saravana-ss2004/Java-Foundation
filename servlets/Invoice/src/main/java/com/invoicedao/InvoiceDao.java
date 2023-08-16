package com.invoicedao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.invoice.Customer;
import com.invoice.Invoice;

@Component
public class InvoiceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int createInvoice(Invoice invoice) {
		try {
			String query = "insert into Invoices (id, invoice_details, sum, status, date, customer_id)values ('"+invoice.getId()+"','"+invoice.getInvoiceDetails()+"','"+invoice.getSum()+"','"+invoice.getStatus()+"','"+invoice.getDate()+"','"+invoice.getCustomerId()+"')";
			jdbcTemplate.update(query);
			return 1;
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	
	public JSONArray getInvoices() {
		String query = "select * from Invoices";
		List<Invoice> invoices = jdbcTemplate.query(query, new InvoiceRowMapper());
		
		
		JSONArray array = new JSONArray();
		
		for(Invoice invoice : invoices) {
			String cus = "select * from Customers where customer_id = '"+invoice.getCustomerId()+"'" ;
			List<Customer> customers = jdbcTemplate.query(cus, new CustomerRowMapper());
			String name = customers.get(0).getCustomerName();
			JSONObject obj = new JSONObject();
			obj.put("id", invoice.getId());
			obj.put("invoice", invoice.getInvoiceNumber());
			obj.put("customerName", name);
			obj.put("status", invoice.getStatus());
			obj.put("amount", invoice.getSum());
			obj.put("date", invoice.getDate());
			array.put(obj);
		}
		return array;
		
	}
	
	public int deleteInvoice(String id) {
		String query = "delete from Invoices where id = '"+id+"'";
		return jdbcTemplate.update(query);
	}
	
	public JSONArray getInvoice(String id) {
		String query = "select * from Invoices where id = '"+id+"'";
		List<Invoice> invoices = jdbcTemplate.query(query, new InvoiceRowMapper());
		
		JSONArray array = new JSONArray();
		for(Invoice invoice : invoices) {
			String cus = "select * from Customers where customer_id = '"+invoice.getCustomerId()+"'" ;
			List<Customer> customers = jdbcTemplate.query(cus, new CustomerRowMapper());
			String name = customers.get(0).getCustomerName();
			String mobile = customers.get(0).getMobileNumber();
			String mail = customers.get(0).getEmail();
			JSONObject obj = new JSONObject();
			obj.put("id", invoice.getId());
			obj.put("invoice", invoice.getInvoiceNumber());
			obj.put("customerName", name);
			obj.put("mobile",mobile);
			obj.put("mail", mail);
			obj.put("status", invoice.getStatus());
			obj.put("amount", invoice.getSum());
			obj.put("date", invoice.getDate());
			obj.put("details", invoice.getInvoiceDetails());
			array.put(obj);
		}
		return array;
	}
	
}
