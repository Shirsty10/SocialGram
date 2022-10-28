package com.example.shirsty.demoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class messageController {

		@RequestMapping("/messages")
		public String display() {
			return "headerMenus/message.html";
		}
	
}
