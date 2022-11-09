package com.example.demo.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a WHERE a.firstName = ?1 AND a.lastName = ?2")
    Optional<Actor> findActorByName(String firstName, String lastName);

    @Query("SELECT a FROM Actor a WHERE a.actorId = ?1")
    Optional<Actor> findActorById(Long actorId);

}
