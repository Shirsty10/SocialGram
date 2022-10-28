package com.example.shirsty.demoProject.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shirsty.demoProject.model.Person;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
@RequestMapping(value = "/public")
public class PersonController {

	@RequestMapping(value = "/newUser", method=GET)
	public String getNewUser(Person person) {
		return "public/newUser.html";
	}
	
	@RequestMapping(value = "/addUser" , method=POST)
	public String addNewUser(Model model, @Valid Person person, Errors errors) {
		if(errors.hasErrors()) {
			log.error("Person form validation failed due to : " + errors.toString());
			return "public/newUser.html";
		}
		
		return "landingPage.html";
	}
}
