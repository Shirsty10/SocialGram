package com.example.shirsty.demoProject.service;

import com.example.shirsty.demoProject.model.NewPost;
import com.example.shirsty.demoProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PostService {
   @Autowired
    private PostRepo postrepo;

    public NewPost savePost(NewPost newpost){
        return postrepo.save(newpost);
    }

}
