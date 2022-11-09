package com.example.demo.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String subscriptionType;
    private Integer age;
}
