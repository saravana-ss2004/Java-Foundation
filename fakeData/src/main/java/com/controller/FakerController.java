package com.controller;

/** 
 * @author Saravanakumar S S (ZSTCH1200/22)
 * @Email saravanakumar.ss@zohocorp.com
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This class maps the respective methods for specific URL
 */
@Controller
public class FakerController {
	Logger logger = Logger.getLogger(FakerController.class.getName());
	@Autowired
	private ApiController api;

	/**
	 * This method for lead module
	 */
	@RequestMapping("/lead")
	public void leadGenerator(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("lead generator method called");

		JSONObject res = api.lead();
		System.out.println(res);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(res);

		System.out.println(response.getStatus() == 200);

		if (response.getStatus() == 200) {
			logger.info("Data addedd successfully");
		}

	}

	/**
	 * This method mapped for contact module
	 */
	@RequestMapping("/contact")
	public void contactGenerator(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("contact generator method called");

		JSONObject res = api.contact();
		System.out.println(res);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(res);

		System.out.println(response.getStatus() == 200);

		if (response.getStatus() == 200) {
			logger.info("data addedd successfully");
		}
	}

	/**
	 * This method mapped for account module
	 */
	@RequestMapping("/account")
	public void accountGenerator(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("account generator method called");

		JSONObject res = api.account();
		System.out.println(res);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(res);

		System.out.println(response.getStatus() == 200);

		if (response.getStatus() == 200) {
			logger.info("data addedd successfully");
		}
	}

	/**
	 * This method mapped for deal module
	 */
	@RequestMapping("/deal")
	public void dealGenerator(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("deal generator method called");

		JSONObject res = api.deal();
		System.out.println(res);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(res);

		System.out.println(response.getStatus() == 200);

		if (response.getStatus() == 200) {
			logger.info("data addedd successfully");
		}

	}
}
