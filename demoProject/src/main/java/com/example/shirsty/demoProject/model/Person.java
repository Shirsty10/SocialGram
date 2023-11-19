package com.example.shirsty.demoProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import com.example.shirsty.demoProject.annotations.ValidatePassword;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ValidatePassword(
		pwd = "pwd",
		cfmpwd = "cfmpwd",
		message = "Passwords do not match!"
)
public class Person extends BaseEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private int personId;

	@NotNull(message = "UserName cannot be null")
	@NotEmpty(message = "UserName cannot be null")
	private String name;

	@NotNull(message = "Birthdate is mandatory field")
	@NotEmpty(message = "Birthdate is mandatory field")
	private String bday;


	@NotEmpty(message = "Password Field cannot be empty")
	private String pwd;

	@Transient
	@NotEmpty(message = "Please confirm the password")
	private String cfmpwd;

	private String bio;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST,targetEntity = Roles.class)
	@JoinColumn(name = "role_id", referencedColumnName = "role_Id",nullable = false)
	private Roles roles;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = Address.class)
	@JoinColumn(name = "add_id", referencedColumnName = "add_id",nullable = true)
	private Address address;

}