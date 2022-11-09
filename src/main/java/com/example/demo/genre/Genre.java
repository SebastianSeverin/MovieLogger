package com.example.demo.genre;

import com.example.demo.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity
@Table
public class Genre {

    @Id
    @SequenceGenerator(
            name = "genre_sequence",
            sequenceName = "genre_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
    )
    private Long genreId;
    private String genreName;
    private String description;
    private Double likeRate;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;

    public Genre() {
    }

    public Genre(String name, String description, Double likeRate) {
        this.genreName = name;
        this.description = description;
        this.likeRate = likeRate;
    }

    public Genre(Long genreId, String name, String description, Double likeRate) {
        this.genreId = genreId;
        this.genreName = name;
        this.description = description;
        this.likeRate = likeRate;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", description='" + description + '\'' +
                ", likeRate=" + likeRate +
                ", movies=" + movies +
                '}';
    }
}
