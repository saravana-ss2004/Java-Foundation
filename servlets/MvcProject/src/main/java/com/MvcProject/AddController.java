package com.MvcProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i,@RequestParam("t2") int j) {
		int k=i+j;
		ModelAndView mv = new ModelAndView();
		mv.addObject("result" , k);
		mv.setViewName("result.jsp");
		return mv;
	}
}
