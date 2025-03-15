package com.algebra.question_generator.config;

import org.springframework.context.annotation.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotEnvConfig {

    public DotEnvConfig() {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("DB_URI", dotenv.get("DB_URI"));
        System.setProperty("KEYSTORE_PATH", dotenv.get("KEYSTORE_PATH"));
        System.setProperty("KEYSTORE_PASSWORD", dotenv.get("KEYSTORE_PASSWORD"));
    }
}
