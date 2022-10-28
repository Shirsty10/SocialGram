package com.example.shirsty.demoProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.shirsty.demoProject.model.User;

@Repository
public interface userRepo extends CrudRepository<User, Integer> {

}