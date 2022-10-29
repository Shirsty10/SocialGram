package com.example.shirsty.demoProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shirsty.demoProject.model.Person;
import com.example.shirsty.demoProject.repository.PersonRepo;

@Controller
public class homeController {
	
	@Autowired
	private PersonRepo personRepo;
	
	@RequestMapping(value = {"/home","/",""})
	public String display(Model model, Authentication auth, HttpSession session) {
		Person person = personRepo.readByName(auth.getName());
		model.addAttribute("username", auth.getName().toUpperCase());
		model.addAttribute("bday",person.getBday() );
		model.addAttribute("location", person.getAddress().getCountry());
		session.setAttribute("loggedInUser", person);
//		System.out.println("Person details "+person);
		//throw new RuntimeException("It's been a bad day!!");
		return "landingPage.html";
	}

}
