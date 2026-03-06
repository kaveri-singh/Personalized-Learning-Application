package com.project.PersonalizedLearningChallengeGenerator.controller;

import com.project.PersonalizedLearningChallengeGenerator.model.Details;
import com.project.PersonalizedLearningChallengeGenerator.service.GeminiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roadmap")
public class RoadmapController {

    private final GeminiClient geminiClient;

    @Autowired
    public RoadmapController(GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateRoadmap(@RequestBody Details request) {
        // Construct the prompt
        String interests = String.join(", ", request.getInterests());

        String prompt = String.format(
                "Generate a personalized learning roadmap based on the following details:\n" +
                        "- Skill Level: %s\n" +
                        "- Interests: %s\n" +
                        "- Learning Goal: %s\n" +
                        "- Preferred Learning Style: %s\n" +
                        "Provide a weekly plan starting from today, broken down into achievable challenges and resources.",
                request.getSkillLevel(),
                interests,
                request.getLearningGoal(),
                request.getPreferredStyle()
        );

        // Call GeminiClient to get the roadmap
        String roadmap = geminiClient.generateRoadmap(prompt);
        return ResponseEntity.ok(roadmap);
    }
}
