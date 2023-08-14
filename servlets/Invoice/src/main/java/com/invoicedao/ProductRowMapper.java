package com.invoicedao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.invoice.Product;

public class ProductRowMapper implements RowMapper<Product> {
	  @Override
	    public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
		  Product product = new Product();
		  product.setProductId(rs.getString("product_id"));
		  product.setProductName(rs.getString("product_name"));
		  product.setProductUnit(rs.getString("unit"));
		  product.setProductPrice(rs.getString("price"));
		  
		  return product;
		  
	  }
}
