package com.project.PersonalizedLearningChallengeGenerator.service;

import com.project.PersonalizedLearningChallengeGenerator.model.Challenge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeGenerator {

    // Method to generate challenges for a specific topic (e.g., "Java", "Spring") based on the skill level
    public List<Challenge> generateChallenges(String topic, String skillLevel) {
        List<Challenge> challenges = new ArrayList<>();

        // Example of challenge generation logic based on topic and skill level
        if ("Java".equalsIgnoreCase(topic)) {
            challenges.add(new Challenge("Variables and Data Types", "Learn the basic data types in Java", skillLevel, topic));
            if ("Advanced".equalsIgnoreCase(skillLevel)) {
                challenges.add(new Challenge("Multithreading in Java", "Learn to create and manage threads", skillLevel, topic));
            }
        }

        if ("Spring".equalsIgnoreCase(topic)) {
            challenges.add(new Challenge("Spring Boot Setup", "Set up a Spring Boot project", skillLevel, topic));
            if ("Advanced".equalsIgnoreCase(skillLevel)) {
                challenges.add(new Challenge("Create a REST API with Spring Boot", "Create a REST API with Spring Boot", skillLevel, topic));
            }
        }

        // Add more topics and skill levels here

        return challenges;
    }
}
