package com.invoicedao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.invoice.Product;

@Component
public class ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveProduct(Product product) {
		
		try {
			String query = "insert into Products values ('"+product.getProductId()+"','"+product.getProductName()+"','"+product.getProductUnit()+"','"+product.getProductPrice()+"')";
			jdbcTemplate.update(query);
			return 1;
			
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}
	
	public JSONArray specificProduct(String id) {
		String query = "select * from Products where product_id = '"+id+"'";
		
		List<Product> products = jdbcTemplate.query(query, new ProductRowMapper());
		JSONArray array = new JSONArray();
		for (Product product : products) {
			JSONObject obj = new JSONObject();
			obj.put("id",product.getProductId());
			obj.put("name",product.getProductName());
			obj.put("unit",product.getProductUnit());
			obj.put("price",product.getProductPrice());
			array.put(obj);
		}
		return array;
	}
	
	public JSONArray getProducts() {
		String query = "select * from Products";
		List<Product> products = jdbcTemplate.query(query, new ProductRowMapper());
		
		JSONArray array = new JSONArray();
		for (Product product : products) {
			JSONObject obj = new JSONObject();
			obj.put("id",product.getProductId());
			obj.put("name",product.getProductName());
			obj.put("unit",product.getProductUnit());
			obj.put("price",product.getProductPrice());
			array.put(obj);
		}
		
		return array;
	}
	
	public int deleteProduct(Product product) {
		String query = "delete from Products where product_id='"+product.getProductId()+"'";
		return jdbcTemplate.update(query);
	}
	
	public int updateProduct(Product product) {
		
		try {
			String query = "update Products set product_name='"+product.getProductName()+"',unit='"+product.getProductUnit()+"',price='"+product.getProductPrice()+"'where product_id='"+product.getProductId()+"'";
			jdbcTemplate.update(query);
			
			return 1;
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}
	
}
