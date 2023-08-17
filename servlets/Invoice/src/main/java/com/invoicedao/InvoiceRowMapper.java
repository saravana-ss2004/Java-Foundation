package com.invoicedao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.invoice.Invoice;

public class InvoiceRowMapper implements RowMapper<Invoice>{
	@Override
	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invoice invoice = new Invoice();
		invoice.setId(rs.getString("id"));
		invoice.setInvoiceNumber(rs.getString("invoice_number"));
		invoice.setInvoiceDetails(rs.getString("invoice_details"));
		invoice.setSum(rs.getInt("sum"));
		invoice.setStatus(rs.getString("status"));
		invoice.setDate(rs.getString("date"));
		invoice.setCustomerId(rs.getString("customerinvoice_id"));
		
		return invoice;
	}
}
