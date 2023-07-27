package com.FileHandle;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/open_file/*")
public class ReadFile extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String requestUrl = req.getRequestURI();
		String subName = requestUrl.substring("FileHandler/open_file/".length());
		String name = subName.substring(1);
		
		if(name != null) {
			CrudOperation co = CrudOperation.getInstance();
			
			PrintWriter out = res.getWriter();
			out.print(co.readFile(name));
		}
		else {
			res.getOutputStream().print("nothing");
		}
	}
}