package com.FileHandle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : saravanakumar S S
 * @Email : saravanakumar.ss@zohocorp.com
 * @Since : 26/07/2023
 */

@WebServlet("/updateFile")
public class UpdateFile extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPut(HttpServletRequest req, HttpServletResponse res) {
		String path = req.getParameter("path");
		String fileName = req.getParameter("fileName");
		String fileContent = req.getParameter("fileContent");
		
		CrudOperation co = CrudOperation.getInstance();
		co.updateFile(fileName, fileContent, path);
	}
}
