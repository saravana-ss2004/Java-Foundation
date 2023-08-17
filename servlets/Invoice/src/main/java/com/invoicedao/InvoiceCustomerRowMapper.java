package com.invoicedao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.invoice.InvoiceCustomer;

public class InvoiceCustomerRowMapper implements RowMapper<InvoiceCustomer> {
	@Override
    public InvoiceCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
		InvoiceCustomer ic = new InvoiceCustomer();
		ic.setCustomerId(rs.getString("customer_id"));
		ic.setCustomerName(rs.getString("customer_name"));
        ic.setEmail(rs.getString("e_mail"));
        ic.setMobileNumber(rs.getString("mobile_number"));
        
        ic.setId(rs.getString("id"));
		ic.setInvoiceNumber(rs.getString("invoice_number"));
		ic.setInvoiceDetails(rs.getString("invoice_details"));
		ic.setSum(rs.getInt("sum"));
		ic.setStatus(rs.getString("status"));
		ic.setDate(rs.getString("date"));
		
		return ic;
	}
	
}
