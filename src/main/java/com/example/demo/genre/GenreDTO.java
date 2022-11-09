package com.example.demo.genre;

import com.example.demo.movie.Movie;
import lombok.Data;

import java.util.Set;

@Data
public class GenreDTO {
    private Long genreId;
    private String genreName;
    private String description;
    private Double likeRate;
    private Set<Movie> movies;
}
