package com.MVC;

import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.invoice.Invoice;
import com.invoicedao.InvoiceDao;


@Component
@Controller
public class InvoiceController {

	@Autowired
	private InvoiceDao invoice;

	@RequestMapping("/addinvoice")
	public void addInvoice(HttpServletRequest request, HttpServletResponse response) {
		try {

			String number = request.getParameter("invoice_number");
			String detail= request.getParameter("detail");
			String sum = request.getParameter("sum");
			String status = request.getParameter("status");
			String date = request.getParameter("date");
			String id = request.getParameter("customer");
			
			System.out.println(detail);

			UUID uniqueKey = UUID.randomUUID();
			System.out.println(uniqueKey);

			int num = invoice.createInvoice(new Invoice(uniqueKey.toString(), number, detail, Integer.parseInt(sum), status, date, id));
			PrintWriter out = response.getWriter();
			out.print(num);
			System.out.println(num);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping("/invoices")
	public JSONObject getinvoices(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject responseObject = new JSONObject();
			responseObject.put("Status",response.getStatus());
			responseObject.put("Message", invoice.getInvoices());
			System.out.println(responseObject);
			PrintWriter out = response.getWriter();
			out.print(responseObject);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/deleteinvoice")
	public void deleteInvoice(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			invoice.deleteInvoice(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/invoice")
	public void getinvoice(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("invoice_id");
			JSONObject responseObject = new JSONObject();
			responseObject.put("Status",response.getStatus());
			responseObject.put("Message", invoice.getInvoice(id));
			System.out.println(responseObject);
			PrintWriter out = response.getWriter();
			out.print(responseObject);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
