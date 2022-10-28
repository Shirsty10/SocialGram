package com.example.shirsty.demoProject.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class errorController {
	
	@ExceptionHandler
	public ModelAndView globalExpHandler(Exception ex) {
		ModelAndView errorPage = new ModelAndView();
		errorPage.setViewName("basePages/error");
		errorPage.addObject("errorMsg" , ex.getMessage());
		return errorPage;
	}

}
