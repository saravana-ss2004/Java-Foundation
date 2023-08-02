package com.spring;

public class Address {
	int dno;
	String street;
	String area;
	
	public Address() {
		
	}
	
	
	public Address(int dno, String street, String area) {
		this.dno = dno;
		this.street = street;
		this.area = area;
	}


	public int getDno() {
		return dno;
	}


	public void setDno(int dno) {
		this.dno = dno;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "Address [dno=" + dno + ", street=" + street + ", area=" + area + "]";
	}
	
	
	
	
}
