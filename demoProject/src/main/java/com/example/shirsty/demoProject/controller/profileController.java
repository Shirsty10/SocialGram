package com.example.shirsty.demoProject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.shirsty.demoProject.model.Address;
import com.example.shirsty.demoProject.model.Person;
import com.example.shirsty.demoProject.model.User;
import com.example.shirsty.demoProject.repository.PersonRepo;
import com.example.shirsty.demoProject.service.UserService;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class profileController {
	
	@Autowired
	private PersonRepo personRepo;

	@GetMapping("/myProfile")
	public ModelAndView display( Model model, Authentication auth,HttpSession session) {
		Person person = (Person)session.getAttribute("loggedInUser");
		User existuser = new User();
		existuser.setName(person.getName());
		existuser.setBday(person.getBday());
		existuser.setBio(person.getBio());
		if(person.getAddress() !=null && person.getAddress().getAdd_id()>0){
		
			existuser.setAdd_content(person.getAddress().getAdd_content());
			existuser.setCity(person.getAddress().getCity());
			existuser.setCountry(person.getAddress().getCountry());
        }
		model.addAttribute("username" , auth.getName().toUpperCase());
		model.addAttribute("roles", auth.getAuthorities().toString());
		ModelAndView modelAndView = new ModelAndView("headerMenus/profile.html");
		modelAndView.addObject("user", existuser);
		return modelAndView ;
	}
	
	@RequestMapping(value = "/saveProfile" , method = POST)
	public String validateUser(Model model, @Valid User user, Errors errors, RedirectAttributes redirectAttributes,HttpSession session) {
		if(errors.hasErrors()) {
			log.error("User form validation failed due to : " + errors.toString());
			return "headerMenus/profile.html";
		}
		Person person = (Person)session.getAttribute("loggedInUser");
		person.setName(user.getName());
		person.setBday(user.getBday());
		person.setBio(user.getBio());
		if(person.getAddress() ==null || !(person.getAddress().getAdd_id()>0)){
            person.setAddress(new Address());
        }
		person.getAddress().setAdd_content(user.getAdd_content());
		person.getAddress().setCity(user.getCity());
		person.getAddress().setCountry(user.getCountry());
		
		Person savedUser = personRepo.save(person);
		session.setAttribute("loggedInUser", savedUser);
		redirectAttributes.addFlashAttribute("message", "Details Updated Successfully");
		return "redirect:/myProfile";
	}
	
	
}
