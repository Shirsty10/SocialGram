package com.example.shirsty.demoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	
	@RequestMapping(value = {"/home","/",""})
	public String display() {
		//model.addAttribute("username", "Krishna");
		//throw new RuntimeException("It's been a bad day!!");
		return "landingPage.html";
	}

}
