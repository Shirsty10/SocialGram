package com.example.shirsty.demoProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Roles extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int role_id;
	private String roleName; 

}
