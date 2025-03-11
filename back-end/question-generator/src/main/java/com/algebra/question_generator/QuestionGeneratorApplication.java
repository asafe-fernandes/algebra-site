package com.algebra.question_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QuestionGeneratorApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URI", dotenv.get("DB_URI"));
        System.setProperty("KEYSTORE_PATH", dotenv.get("KEYSTORE_PATH"));
        System.setProperty("KEYSTORE_PASSWORD", dotenv.get("KEYSTORE_PASSWORD"));

        SpringApplication.run(QuestionGeneratorApplication.class, args);

    }

}
