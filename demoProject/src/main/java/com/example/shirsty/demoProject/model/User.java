package com.example.shirsty.demoProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class User extends BaseEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
	private int userId;
	
	@NotBlank(message="Name Cannot be left blank")
	private String name;
	@NotEmpty(message="BirthDate Cannot be left blank")
	private String bday;

	private String bio;
	
	
}
