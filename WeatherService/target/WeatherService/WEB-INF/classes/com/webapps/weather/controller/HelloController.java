package com.webapps.weather.controller;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String printWelcome(ModelMap model){
		model.addAllAttributes("message","Hello from spring mvc");
		return "hello";
	}
}
