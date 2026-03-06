package com.project.PersonalizedLearningChallengeGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
        private String title;
        private String description;
        private String difficulty;
        private String category;
}