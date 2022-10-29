package com.example.shirsty.demoProject.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	 @NotBlank(message="Address must not be blank")
	 @Size(min=5, message="Address must be at least 5 characters long")
	 private String add_content;
	

    @NotBlank(message="City must not be blank")
    @Size(min=5, message="City must be at least 5 characters long")
    private String city;

    @NotBlank(message="Country must not be blank")
    @Size(min=5, message="Country must be at least 5 characters long")
    private String country;
	
	
	
}
