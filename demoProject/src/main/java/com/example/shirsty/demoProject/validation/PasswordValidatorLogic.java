package com.example.shirsty.demoProject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.example.shirsty.demoProject.annotations.ValidatePassword;

public class PasswordValidatorLogic implements ConstraintValidator<ValidatePassword, Object> {

	private String pwd;
	private String cfmpwd;
	
	
	
	@Override
	public void initialize(ValidatePassword constraintAnnotation) {
		this.pwd = constraintAnnotation.pwd();
		this.cfmpwd = constraintAnnotation.cfmpwd();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}



	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object pwdValue = new BeanWrapperImpl(value).getPropertyValue(pwd);
		Object cfmpwdValue = new BeanWrapperImpl(value).getPropertyValue(cfmpwd);
		if(cfmpwdValue !=null ) {
			return pwdValue.equals(cfmpwdValue);
		}
		else {
			return cfmpwdValue == null;
		}
	}

}
