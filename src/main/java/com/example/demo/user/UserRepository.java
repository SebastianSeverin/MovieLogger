package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    Optional<User> findUserById(Long userId);

    @Query("SELECT u FROM User u WHERE u.firstName = ?1 AND u.lastName = ?2")
    Optional<User> findUserByFullName(String firstName, String lastName);


}
