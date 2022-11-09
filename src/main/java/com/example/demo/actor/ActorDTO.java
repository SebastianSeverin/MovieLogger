package com.example.demo.actor;

import com.example.demo.movie.Movie;
import lombok.Data;

import java.util.Set;

@Data
public class ActorDTO {
    private Long actorId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer numberOfAwards;
    private Set<Movie> movies;
}
