package com.example.shirsty.demoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shirsty.demoProject.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Person readByName(String name);

}
