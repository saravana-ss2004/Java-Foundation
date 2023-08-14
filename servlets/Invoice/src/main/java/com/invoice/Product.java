package com.invoice;

public class Product {
	private String productId;
	private String productName;
	private String productUnit;
	private String productPrice;
	
	
	public Product(String productId, String productName, String productUnit, String productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productUnit  = productUnit;
		this.productPrice = productPrice;
	}
	
	public Product() {
		
	}
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
