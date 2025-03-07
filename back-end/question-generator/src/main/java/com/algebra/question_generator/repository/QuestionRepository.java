package com.algebra.question_generator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.algebra.question_generator.model.domains.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

    @Query("{'rating': {$gte: ?0, $lte: ?1}}")
    List<Question> findQuestionByRating(double minRating, double maxRating);
}
