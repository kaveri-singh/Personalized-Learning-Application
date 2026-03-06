package com.project.PersonalizedLearningChallengeGenerator.controller;

import com.project.PersonalizedLearningChallengeGenerator.model.Users;
import com.project.PersonalizedLearningChallengeGenerator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void createUser(@RequestBody Users user){
        userService.saveNewUser(user);
    }

}

