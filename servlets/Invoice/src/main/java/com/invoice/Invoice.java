package com.invoice;

public class Invoice {
	private String id;
	private String invoiceNumber;
	private String invoiceDetails; 
	private int sum;
	private String status;
	private String date;
	private String customerId;
	
	
	public Invoice(String id, String invoiceNumber, String invoiceDetails, int sum, String status, String date, String customerId) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDetails = invoiceDetails;
		this.sum = sum;
		this.status = status;
		this.date = date;
		this.customerId = customerId;
	}
	
	public Invoice() {
		
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
	
	
}
