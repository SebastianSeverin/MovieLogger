package com.example.demo.genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GenreConfig {
    @Bean
    CommandLineRunner commandLineRunnerGenres(GenreRepository repository) {
        return args -> {
            Genre drama = new Genre(
                    "drama",
                    "Very dramatic",
                    93.0
            );

            Genre sciFi = new Genre(
                    "sci-fi",
                    "Science Fiction is about fictional science",
                    78.5
            );

            repository.saveAll(List.of(drama, sciFi));
        };
    }
}
