package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository) {
        return args -> {
            User danNegru = new User(
                    "Dan",
                    "Negru",
                    "danutzunegru",
                    "premium",
                    44
            );

            User anto = new User(
                    "Antonio",
                    "Mares",
                    "limitatare",
                    "economy",
                    21
            );
            repository.saveAll(List.of(danNegru, anto));
        };
    }
}
