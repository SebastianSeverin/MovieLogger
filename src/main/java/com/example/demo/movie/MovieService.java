package com.example.demo.movie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getMovies() {
        return List.of(
                new Movie(1L,
                        "Titanic",
                        "drama",
                        128,
                        8.9,
                        LocalDate.of(1998, Month.JUNE, 24))
        );
    }
}
