package com.run;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cfg.AppConfig;
import com.invoice.Invoice;
import com.invoicedao.InvoiceDao;

@Component
public class Test {
	public static void main(String[] args) {
		
		
		ApplicationContext a = new AnnotationConfigApplicationContext(AppConfig.class);
		InvoiceDao dao = (InvoiceDao)a.getBean(InvoiceDao.class);
		dao.createInvoice(new Invoice("234", "2", "{milk : {quantity : 2, price : 64}, biscuit : {quantity : 4, price : 20}}", 84, "paid", "14-08-2023","7896"));
		
		
	}
}
