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

import com.invoice.Product;
import com.invoicedao.ProductDao;

@Component
@Controller
public class productController {
	
	@Autowired
	private ProductDao product;
	
	
	@RequestMapping("/products")
	public JSONObject getProducts(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject responseObject = new JSONObject();
			responseObject.put("Status",response.getStatus());
			responseObject.put("Message", product.getProducts());
			System.out.println(responseObject);
			PrintWriter out = response.getWriter();
			out.print(responseObject);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/product")
	public JSONObject getProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("product_id");
			JSONObject responseObject = new JSONObject();
			responseObject.put("Status",response.getStatus());
			responseObject.put("Message", product.specificProduct(id));
			System.out.println(responseObject);
			PrintWriter out = response.getWriter();
			out.print(responseObject);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/addproduct")
	public void saveProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String ProductName = request.getParameter("product_name");
			String unit = request.getParameter("unit");
			String price = request.getParameter("price");
			
			UUID uniqueKey = UUID.randomUUID();
			System.out.println (uniqueKey);
			 
			int num = product.saveProduct(new Product(uniqueKey.toString(), ProductName, unit, price));
			PrintWriter out = response.getWriter();
			out.print(num);
			System.out.println(num);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/deleteproduct")
	public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String productId = request.getParameter("product_id");
			product.deleteProduct(new Product(productId, null, null, null));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/editproduct")
	public void editProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String ProductName = request.getParameter("product_name");
			String unit = request.getParameter("unit");
			String price = request.getParameter("price");
			String id = request.getParameter("product_id");
			
			 
			int num = product.updateProduct(new Product(id, ProductName, unit, price));
			PrintWriter out = response.getWriter();
			out.print(num);
			System.out.println(num);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
