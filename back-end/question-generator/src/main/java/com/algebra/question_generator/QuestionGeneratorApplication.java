package com.algebra.question_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QuestionGeneratorApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URI", dotenv.get("DB_URI"));

        SpringApplication.run(QuestionGeneratorApplication.class, args);

    }

}
