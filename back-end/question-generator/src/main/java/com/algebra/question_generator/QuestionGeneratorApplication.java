package com.algebra.question_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.algebra.question_generator.config.DotEnvConfig;

@SpringBootApplication
public class QuestionGeneratorApplication {

    public static void main(String[] args) {
        new DotEnvConfig();
        SpringApplication.run(QuestionGeneratorApplication.class, args);
    }

}
