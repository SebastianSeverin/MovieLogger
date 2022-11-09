package com.example.demo.actor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class ActorConfig {

    @Bean
    CommandLineRunner commandLineRunnerActors(ActorRepository repository) {
        return args -> {
            Actor diCaprio = new Actor(
                    "Leonardo",
                    "Di Caprio",
                    44,
                    3
            );

            Actor depp = new Actor(
                    "Johnny",
                    "Depp",
                    42,
                    9
            );

            repository.saveAll(List.of(diCaprio, depp));
        };
    }
}
