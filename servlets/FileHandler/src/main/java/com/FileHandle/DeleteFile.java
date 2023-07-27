package com.FileHandle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete_file/*")
public class DeleteFile extends HttpServlet{
	public void doDelete(HttpServletRequest req, HttpServletResponse res){
		String requestUrl = req.getRequestURI();
		String subName = requestUrl.substring("FileHandler/delete_file/".length());
		String fileName = subName.substring(1);
		
		CrudOperation co = CrudOperation.getInstance();
		co.deleteFile(fileName);
	}
}
