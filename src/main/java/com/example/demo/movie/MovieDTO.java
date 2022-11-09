package com.example.demo.movie;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDTO {
    private Long id;
    private String name;
    private String genreName;
    private Integer length;
    private Double rating;
    private LocalDate releaseYear;
}
