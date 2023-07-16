package com.example.shirsty.demoProject.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.shirsty.demoProject.annotations.ValidatePassword;

import lombok.Data;

@Data
@ValidatePassword(
        pwd = "pwd",
        cfmpwd = "cfmpwd",
        message = "Passwords do not match!"
)
public class Person {
	@NotNull(message = "UserName cannot be null")
	@NotEmpty(message = "UserName cannot be null")
	String name;
	
	@NotNull(message = "Birthdate is mandatory field")
	@NotEmpty(message = "Birthdate is mandatory field")
	String bday;
	
	
	@NotEmpty(message = "Password Field cannot be empty")
	String pwd;
	
	@NotEmpty(message = "Please confirm the password")
	String cfmpwd;
	
	String bio;
	

}
