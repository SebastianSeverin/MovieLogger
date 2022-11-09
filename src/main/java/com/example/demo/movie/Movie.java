package com.example.demo.movie;

import com.example.demo.actor.Actor;
import com.example.demo.genre.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(
        name = "genre",
        nullable = true
    )
    private Genre genre;
    private Integer length;
    private Double rating;
    private LocalDate releaseYear;

    @ManyToMany
    @JoinTable(
            name = "movieCast",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "actorId")
    )
    private Set<Actor> cast;

    public Movie() {
    }

    public Movie(Long id, String name, Genre genre, Integer length, Double rating, LocalDate releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.length = length;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public Movie(String name, Genre genre, Integer length, Double rating, LocalDate releaseYear) {
        this.name = name;
        this.genre = genre;
        this.length = length;
        this.rating = rating;
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
