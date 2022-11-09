package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "appUsers")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String subscriptionType;
    private Integer age;

    public User(Long userId, String firstName, String lastName, String username, String subscriptionType, Integer age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.subscriptionType = subscriptionType;
        this.age = age;
    }

    public User() {
    }

    public User(String firstName, String lastName, String username, String subscriptionType, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.subscriptionType = subscriptionType;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", age=" + age +
                '}';
    }
}
