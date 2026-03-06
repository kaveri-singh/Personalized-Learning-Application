package com.project.PersonalizedLearningChallengeGenerator.service;

import com.project.PersonalizedLearningChallengeGenerator.model.*;
import com.project.PersonalizedLearningChallengeGenerator.repository.RoadmapRepository;
import com.project.PersonalizedLearningChallengeGenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoadmapService {

    @Autowired
    private RoadmapRepository roadmapRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChallengeGenerator challengeGenerator;

    // Generate roadmap for the user based on their details
    public Roadmap generateRoadmapForUser(String username) {
        Users user = userRepository.findByUsername(username);
        if (user == null || user.getDetails() == null) return null;

        Details userDetails = user.getDetails();

        Roadmap roadmap = new Roadmap();
        roadmap.setUserId(user.getId()); // ✅ Correct ObjectId set
        roadmap.setTitle("Personalized Roadmap for " + username);
        roadmap.setDescription("Generated based on user preferences");

        List<Step> steps = generateSteps(userDetails);
        roadmap.setSteps(steps);

        return roadmapRepository.save(roadmap);
    }

    // Helper to generate steps based on interests and skill level
    private List<Step> generateSteps(Details userDetails) {
        List<Step> steps = new ArrayList<>();

        if (userDetails.getInterests().contains("Java")) {
            Step javaStep = new Step(
                    "Learn Java Basics",
                    "Start with understanding variables, data types, and control structures",
                    challengeGenerator.generateChallenges("Java", userDetails.getSkillLevel())
            );
            steps.add(javaStep);
        }

        if (userDetails.getInterests().contains("Spring")) {
            Step springStep = new Step(
                    "Learn Spring Framework",
                    "Learn the basics of Spring Boot and REST APIs",
                    challengeGenerator.generateChallenges("Spring", userDetails.getSkillLevel())
            );
            steps.add(springStep);
        }

        // You can add more conditional steps here

        return steps;
    }

    // Method to get roadmap for a specific user
    public Roadmap getRoadmapForUser(String username) {
        Users user = userRepository.findByUsername(username);
        if (user == null) return null;

        return roadmapRepository.findByUserId(user.getId());
    }
}
