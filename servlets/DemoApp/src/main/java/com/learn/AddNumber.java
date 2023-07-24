package com.learn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddNumber extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	int a = Integer.parseInt(req.getParameter("num1"));
    	int b = Integer.parseInt(req.getParameter("num2"));
    	
    	int k= a+b;
    	
    	HttpSession session = req.getSession();
    	session.setAttribute("k",k);
    	
		res.sendRedirect("one?k="+k);
		
		
//		RequestDispatcher rs = req.getRequestDispatcher("one");
//		rs.forward(req,res);
		
        
    }
}
