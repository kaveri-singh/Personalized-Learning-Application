package com.project.PersonalizedLearningChallengeGenerator.controller;

import com.project.PersonalizedLearningChallengeGenerator.model.Details;
import com.project.PersonalizedLearningChallengeGenerator.model.Users;
import com.project.PersonalizedLearningChallengeGenerator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class DetailController {

    @Autowired
    private UserService userService;

    // Get current user's learning details
    @GetMapping
    public ResponseEntity<Details> getUserDetails() {
        Users user = getLoggedInUser();
        Details details = user.getDetails();

        return (details != null)
                ? new ResponseEntity<>(details, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Save new details for current user
    @PostMapping
    public ResponseEntity<Details> saveUserDetails(@RequestBody Details details) {
        Users user = getLoggedInUser();
        user.setDetails(details);
        userService.saveUser(user);
        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }

    // Update specific fields of existing user details
    @PutMapping
    public ResponseEntity<Details> updateUserDetails(@RequestBody Details newDetails) {
        Users user = getLoggedInUser();
        Details existingDetails = user.getDetails();

        if (existingDetails == null) {
            existingDetails = new Details();
        }

        // Update fields conditionally
        if (newDetails.getSkillLevel() != null)
            existingDetails.setSkillLevel(newDetails.getSkillLevel());

        if (newDetails.getLearningGoal() != null)
            existingDetails.setLearningGoal(newDetails.getLearningGoal());

        if (newDetails.getPreferredStyle() != null)
            existingDetails.setPreferredStyle(newDetails.getPreferredStyle());

        if (newDetails.getInterests() != null && !newDetails.getInterests().isEmpty())
            existingDetails.setInterests(newDetails.getInterests());

        user.setDetails(existingDetails);
        userService.saveUser(user);
        return new ResponseEntity<>(existingDetails, HttpStatus.OK);
    }

    // Helper to get logged-in user
    private Users getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findByUsername(username);
    }
}
