package com.invoice;

public class InvoiceCustomer {
	private String id;
	private String invoiceNumber;
	private String invoiceDetails; 
	private int sum;
	private String status;
	private String date;
	private String customerId;
	private String customerName;
	private String email;
	private String mobileNumber;
	
	
	public InvoiceCustomer(String id, String invoiceNumber, String invoiceDetails, int sum, String status, String date,
			String customerId, String customerName, String email, String mobileNumber) {
		super();
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDetails = invoiceDetails;
		this.sum = sum;
		this.status = status;
		this.date = date;
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}


	public InvoiceCustomer() {
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(String invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
	
}
