package com.project.PersonalizedLearningChallengeGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Step {
    private String title;
    private String objective;
    private List<Challenge> challenges;
}
