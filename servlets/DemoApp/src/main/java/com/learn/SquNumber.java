package com.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/one")
public class SquNumber extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession session = req.getSession();
		int k = (int) session.getAttribute("k");
        PrintWriter out = res.getWriter();
        out.println("value of k^2 : "+ k*k);
    }
}
