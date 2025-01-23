package com.algebra.question_generator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.algebra.question_generator.model.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

}
