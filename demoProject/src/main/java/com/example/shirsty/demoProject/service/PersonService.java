package com.example.shirsty.demoProject.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> origin/master
import org.springframework.stereotype.Service;

import com.example.shirsty.demoProject.model.Person;
import com.example.shirsty.demoProject.model.Roles;
import com.example.shirsty.demoProject.repository.PersonRepo;
import com.example.shirsty.demoProject.repository.RolesRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {
	
	@Autowired
	private RolesRepo rolesRepo;
	
	@Autowired
	private PersonRepo personRepo;
	
<<<<<<< HEAD
	@Autowired
	private PasswordEncoder passwordEncoder;
	
=======
>>>>>>> origin/master
	public boolean createNewPerson(Person person) {
		boolean isSaved = false;
		Roles roles = rolesRepo.getByRoleName("USER");
		person.setRoles(roles);
<<<<<<< HEAD
		person.setPwd(passwordEncoder.encode(person.getPwd()));
		person = personRepo.save(person);
		if(null!= person && person.getPerson_id()>0) {
=======
		person = personRepo.save(person);
		if(null!= person && person.getPersonId()>0) {
>>>>>>> origin/master
			isSaved = true;
		}
		return isSaved;
	}

}