package com.example.demo.actor;

import com.example.demo.movie.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Actor {

    @Id
    @SequenceGenerator(
            name = "actor_sequence",
            sequenceName = "actor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "actor_sequence"
    )
    private Long actorId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer numberOfAwards;

    @ManyToMany(mappedBy = "cast")
    private Set<Movie> portfolio;

    public Actor() {
    }

    public Actor(String firstName, String lastName, Integer age, Integer numberOfAwards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.numberOfAwards = numberOfAwards;
    }

    public Actor(Long actorId, String firstName, String lastName, Integer age, Integer numberOfAwards) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.numberOfAwards = numberOfAwards;
    }
    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", numberOfAwards=" + numberOfAwards +
                '}';
    }
}
