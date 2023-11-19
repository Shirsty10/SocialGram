package com.example.shirsty.demoProject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shirsty.demoProject.model.NewPost;
import com.example.shirsty.demoProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class loginController {

	@Autowired
	private PostService postService;

	@RequestMapping(value ="/login",method = { RequestMethod.GET, RequestMethod.POST })
	public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
								   @RequestParam(value = "logout", required = false) String logout,
								   @RequestParam(value = "register", required = false) String register,Model model) {
			String errorMessge = null;
		System.out.println("Person details "+ model);
			if(error != null) {
				errorMessge = "Username or Password is incorrect !!";
			}
			if(logout != null) {
				errorMessge = "You have been successfully logged out !!";
			}
			if(register != null) {
				errorMessge = "You are Successfully registered!! login with new Credentials";
			}

			model.addAttribute("errorMessge", errorMessge);
			return "basePages/login.html";
		}

	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout=true";
	    }


}
