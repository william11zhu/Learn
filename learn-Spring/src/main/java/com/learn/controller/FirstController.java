package com.learn.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class FirstController extends GenericServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping("show")
	@ResponseBody
	public String show(String name) {
		
		return name;
	}
	
	@RequestMapping("index")
	public String showIndex() {
		System.out.println("index");
		return "index";
	}

	@RequestMapping("get")
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.getInitParameterNames();
		
	}
	
}
