package com.example.shirsty.demoProject.repository;

import com.example.shirsty.demoProject.model.NewPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<NewPost, Integer> {
}
