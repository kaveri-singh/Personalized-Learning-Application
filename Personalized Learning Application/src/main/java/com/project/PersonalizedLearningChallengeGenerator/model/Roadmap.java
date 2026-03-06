package com.project.PersonalizedLearningChallengeGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "roadmaps")
public class Roadmap {
    @Id
    private ObjectId id;

    @Field("userId")
    private ObjectId userId;

    private String title;
    private String description;
    private List<Step> steps;
}
