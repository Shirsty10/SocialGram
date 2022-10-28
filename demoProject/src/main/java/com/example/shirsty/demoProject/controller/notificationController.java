package com.example.shirsty.demoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class notificationController {
	@RequestMapping("/notification")
	public String display() {
		return "headerMenus/notification.html";
	}
}
