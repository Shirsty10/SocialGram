package com.example.shirsty.demoProject.controller;

import com.example.shirsty.demoProject.model.NewPost;
import com.example.shirsty.demoProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private PostService postService;
    @PostMapping(value = "/public/newPost")
    public ResponseEntity<NewPost> addPost(@RequestBody NewPost newPost){
        System.out.println("New post data "+ newPost);
        postService.savePost(newPost);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
}
