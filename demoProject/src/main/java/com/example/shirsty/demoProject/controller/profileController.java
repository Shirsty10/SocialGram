package com.example.shirsty.demoProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.shirsty.demoProject.model.User;
import com.example.shirsty.demoProject.service.UserService;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class profileController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/myProfile")
	public String display(User user) {
		return "headerMenus/profile.html";
	}
	
	@RequestMapping(value = "/saveProfile" , method = POST)
	public String validateUser(Model model, @Valid User user, Errors errors, RedirectAttributes redirectAttributes) {
		if(errors.hasErrors()) {
			log.error("User form validation failed due to : " + errors.toString());
			return "headerMenus/profile.html";
		}
		userService.saveUser(user);
		redirectAttributes.addFlashAttribute("message", "Details Updated Successfully");
		return "redirect:/myProfile";
	}
	
	
}
