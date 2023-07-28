package com.FileHandle;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author : saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 26/07/2023
 */


@WebServlet("/open_file")
public class ReadFile extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String fileName = req.getParameter("fileName");
		String path = req.getParameter("path");
	
				CrudOperation co = CrudOperation.getInstance();
				
				PrintWriter out = res.getWriter();
				out.print(co.readFile(fileName, path));
		
	}
}