package com.example.demo.movie;

import java.time.LocalDate;

public class Movie {
    private Long id;
    private String name;
    private String genre;
    private Integer length;
    private Double rating;
    private LocalDate releaseYear;

    public Movie() {
    }

    public Movie(Long id, String name, String genre, Integer length, Double rating, LocalDate releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.length = length;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public Movie(String name, String genre, Integer length, Double rating, LocalDate releaseYear) {
        this.name = name;
        this.genre = genre;
        this.length = length;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getLength() {
        return length;
    }

    public Double getRating() {
        return rating;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", length=" + length +
                ", rating=" + rating +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
