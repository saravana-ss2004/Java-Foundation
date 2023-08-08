package com.springJdbc;

import org.springframework.stereotype.Component;

public class DatabaseConnection {
	String url;
	String uname;
	String pass;
	public DatabaseConnection() {
		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname="saravana";
		String pass = "sethupathi790";
	}
}
