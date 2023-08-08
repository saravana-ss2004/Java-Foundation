package com.jdbc;

import java.sql.*;

public class DatabaseConnectivity {
	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname="saravana";
		String pass = "sethupathi790";
		String query = "select * from students";
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2));
		}
		
	}
}