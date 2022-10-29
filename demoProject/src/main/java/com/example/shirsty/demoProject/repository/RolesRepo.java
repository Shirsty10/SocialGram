package com.example.shirsty.demoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shirsty.demoProject.model.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {
     Roles getByRoleName(String roleName);
}
