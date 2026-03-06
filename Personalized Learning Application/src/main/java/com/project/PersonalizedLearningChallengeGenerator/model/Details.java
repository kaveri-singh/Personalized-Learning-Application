package com.project.PersonalizedLearningChallengeGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Details {

    private String skillLevel;
    private List<String> interests;
    private String learningGoal;
    private String preferredStyle;
    private LocalDateTime date;

}
