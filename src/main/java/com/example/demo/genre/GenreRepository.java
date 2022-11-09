package com.example.demo.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("SELECT g FROM Genre g WHERE g.genreName = ?1")
    Optional<Genre> findGenreByName(String name);

    @Query("SELECT g FROM Genre g WHERE g.genreId = ?1")
    Optional<Genre> findGenreById(Long genreId);
}
