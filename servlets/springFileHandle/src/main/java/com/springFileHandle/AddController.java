package com.springFileHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springFileHandle.service.CheckFile;
import com.springFileHandle.service.CrudFile;

/**
 * @Author SaravanaKumar S S
 * @Email saravanakumar.ss@zohocorp.com
 * @since 02/08/2023
 */

/*
 * The @Component annotation creates bean for this class.
 * The @Controller annotation indicates, this class serves the role of a controller.
 */

@Component
@Controller

/**
 * This class has controller role for model and view
 * And it contains controller methods for CRUD operations(file)
 */
public class AddController {
	ModelAndView mv;
	CheckFile cf;
	CrudFile cr;
	private ApplicationContext context;
	
	/**
	 * This method initializes the ModelAndView class
	 * and Beans
	 */
	public void init() {
		mv = new ModelAndView();
		mv.setViewName("display.jsp");
		
		context = new AnnotationConfigApplicationContext(crudConfig.class);
		cf = (CheckFile) context.getBean("check");
		cr  = (CrudFile) context.getBean("crud");
	}
	
	/**
	 * This method has control for create the file
	 * @param request servelet request
	 * @param response servlet response
	 * @return display.jsp file and shows the output
	 */
	@RequestMapping("/create")
	public ModelAndView createFile(HttpServletRequest request, HttpServletResponse response) {
		AddController controller = new AddController();
		controller.init();
		
		String output;
		String filePath = request.getParameter("filePath");
		String fileName = request.getParameter("fileName");
		
		Boolean isFileExists =controller.cf.checkFile(filePath, fileName);
		
		if(isFileExists == false) {
			output = controller.cr.crudCreate(filePath, fileName);
			controller.mv.addObject("result",output);
			return controller.mv;
		}
		else {
			controller.mv.addObject("result","File already Exists");
			return controller.mv;
		}
	}
	
	/**
	 * This method has control for read the file
	 * @param request servelet request
	 * @param response servlet response
	 * @return display.jsp file and shows the output
	 */
	@RequestMapping("/read")
	public ModelAndView readFile(HttpServletRequest request, HttpServletResponse response) {
		AddController controller = new AddController();
		controller.init();
		
		String output;	
		String filePath = request.getParameter("filePath");
		String fileName = request.getParameter("fileName");
		
		Boolean isFileExists =controller.cf.checkFile(filePath, fileName);
		
		if(isFileExists == true) {
			output=controller.cr.crudRead(filePath, fileName);
			controller.mv.addObject("result",output);
			return controller.mv;
		}
		else {
			controller.mv.addObject("result","File not found");
			return controller.mv;
		}
	}
	
	/**
	 * This method has control for write(update) the file
	 * @param request servelet request
	 * @param response servlet response
	 * @return display.jsp file and shows the output
	 */
	@RequestMapping("/write")
	public ModelAndView writeFile(HttpServletRequest request, HttpServletResponse response) {
		AddController controller = new AddController();
		controller.init();
		
		String output;
		String filePath = request.getParameter("filePath");
		String fileName = request.getParameter("fileName");
		String fileContent = request.getParameter("fileContent");
		
		Boolean isFileExists =controller.cf.checkFile(filePath, fileName);
			
		if(isFileExists == true) {
			output = controller.cr.crudUpdate(filePath, fileName, fileContent);
			controller.mv.addObject("result",output);
			return controller.mv;
		}
		else {
			controller.mv.addObject("result","File not found");
			return controller.mv;
		}
	}
	
	/**
	 * This method has control for delete the file
	 * @param request servelet request
	 * @param response servlet response
	 * @return display.jsp file and shows the output
	 */
	@RequestMapping("/delete")
	public ModelAndView deleteFile(HttpServletRequest request, HttpServletResponse response) {
		AddController controller = new AddController();
		controller.init();
		
		String output;
		String filePath = request.getParameter("filePath");
		String fileName = request.getParameter("fileName");
		
		Boolean isFileExists =controller.cf.checkFile(filePath, fileName);
	
		if(isFileExists == true) {
			output = controller.cr.crudDelete(filePath, fileName);
			controller.mv.addObject("result",output);
			return controller.mv;
		}
		else {
			controller.mv.addObject("result","File not found");
			return controller.mv;
		}
	}
}
