package com.example.shirsty.demoProject.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shirsty.demoProject.model.User;
import com.example.shirsty.demoProject.repository.userRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private userRepo userRepo;
	
	public boolean saveUser(User user) {
		boolean isSave = false;
//		user.setCreatedAt(LocalDateTime.now());
//		user.setCreatedBy("someone");
		User saveNewUser = userRepo.save(user);
		if(null != saveNewUser && saveNewUser.getUserId()>0) {
			isSave = true;
		}
		return isSave;
	}

}
