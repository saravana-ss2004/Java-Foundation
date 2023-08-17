package com.invoicedao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.invoice.Customer;
import com.invoice.Invoice;
import com.invoice.InvoiceCustomer;

@Component
public class InvoiceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int createInvoice(Invoice invoice) {
		try {
			String query = "insert into Invoices (id, invoice_details, sum, status, date, customerinvoice_id)values ('"+invoice.getId()+"','"+invoice.getInvoiceDetails()+"','"+invoice.getSum()+"','"+invoice.getStatus()+"','"+invoice.getDate()+"','"+invoice.getCustomerId()+"')";
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
		String query = "select * from Invoices  inner join Customers ON Invoices.customerinvoice_id = Customers.customer_id where id = '"+id+"'"; 
		List<InvoiceCustomer> invoices = jdbcTemplate.query(query, new InvoiceCustomerRowMapper());
		
		JSONArray array = new JSONArray();
		
		for(InvoiceCustomer invoice : invoices) {
			JSONObject obj = new JSONObject();
			obj.put("invoice_id", invoice.getId());
			obj.put("invoice_number", invoice.getInvoiceNumber());
			obj.put("details", invoice.getInvoiceDetails());
			obj.put("sum", invoice.getSum());
			obj.put("status", invoice.getStatus());
			obj.put("date", invoice.getDate());
			
			obj.put("customer_id", invoice.getCustomerId());
			obj.put("customer_name", invoice.getCustomerName());
			obj.put("email", invoice.getEmail());
			obj.put("mobile", invoice.getMobileNumber());
			array.put(obj);
			
			return array;
			
		}
		
		return null;
	}
	
	public int editInvoice(Invoice invoice) {
		String query = "update Invoices set invoice_details='"+invoice.getInvoiceDetails()+"',sum='"+invoice.getSum()+"',status='"+invoice.getStatus()+"',date='"+invoice.getDate()+"',customerinvoice_id='"+invoice.getCustomerId()+"' where id='"+invoice.getId()+"'";
		return jdbcTemplate.update(query);
	}
	
	
	
	public JSONArray getSpecifiedInvoice(String customerId) {
		String query = "select * from Invoices where customerinvoice_id = '"+customerId+"'";
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
	
	
}
