package com.FileHandle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createFile/*")
public class CreateFile extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String requestUrl = req.getRequestURI();
		String subName = requestUrl.substring("FileHandler/createFile/".length());
		String fileName = subName.substring(1);
		
		CrudOperation co = CrudOperation.getInstance();
		co.initFile(fileName);
	}
}
