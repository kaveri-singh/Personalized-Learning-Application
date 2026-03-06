package com.project.PersonalizedLearningChallengeGenerator.repository;

import com.project.PersonalizedLearningChallengeGenerator.model.Roadmap;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadmapRepository extends MongoRepository<Roadmap, ObjectId> {
    Roadmap findByUserId(ObjectId userId);
}
