package com.example.demo.movie;

import com.example.demo.genre.Genre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository) {
        return args -> {
            Movie titanic = new Movie(
                    "Titanic",
                    new Genre(1L,
                            "drama",
                            "Very dramatic",
                            93.0
                    ),
                    128,
                    8.9,
                    LocalDate.of(1998, Month.JUNE, 24)
            );

            Movie poc = new Movie(
                    "Pirates of the Caribbean",
                    new Genre(2L,
                            "sci-fi",
                            "Science Fiction is about fictional science",
                            78.5
                    ),
                    150,
                    9.1,
                    LocalDate.of(2001, Month.APRIL, 12)
            );

            repository.saveAll(List.of(titanic, poc));
        };
    }
}
