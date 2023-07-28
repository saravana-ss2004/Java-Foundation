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

@WebServlet("/delete_file")
public class DeleteFile extends HttpServlet{
	public void doDelete(HttpServletRequest req, HttpServletResponse res){
		String fileName = req.getParameter("fileName");
		String path = req.getParameter("path");
		
		CrudOperation co = CrudOperation.getInstance();
		co.deleteFile(fileName, path);
	}
}
