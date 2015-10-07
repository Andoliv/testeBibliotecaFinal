package br.com.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

	/*
	@RequestMapping("/index")
	String home() {
		return "index";
	}
	*/
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
}
