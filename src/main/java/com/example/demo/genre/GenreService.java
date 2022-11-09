package com.example.demo.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreDTO> getGenres() {
        return genreRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    public void addNewGenre(Genre genre) {
        Optional<Genre> genreOptional = genreRepository.findGenreByName(genre.getGenreName());
        if (genreOptional.isPresent()) {
            throw new IllegalStateException("genre already registered");
        }
        genreRepository.save(genre);
    }

    public void deleteGenre(Long genreId) {
        boolean exists = genreRepository.existsById(genreId);
        if (!exists) {
            throw new IllegalStateException("genre with id " + genreId + " does not exist!");
        }
        genreRepository.deleteById(genreId);
    }

    private GenreDTO convertEntityToDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreId(genre.getGenreId());
        genreDTO.setGenreName(genre.getGenreName());
        genreDTO.setDescription(genre.getDescription());
        genreDTO.setMovies(genre.getMovies());
        return genreDTO;
    }

    @Transactional
    public void updateGenre(Long genreId, String genreName, String description, Double likeRate) {
        Genre genre = genreRepository.findGenreById(genreId)
                .orElseThrow(() -> new IllegalStateException(
                        "Genre with id " + genreId + " does not exist!"
                ));

        if (genreName != null && genreName.length() > 0 &&
        !Objects.equals(genre.getGenreName(), genreName)) {
            Optional<Genre> genreOptional = genreRepository.findGenreByName(genreName);
            if (genreOptional.isPresent()) {
                throw new IllegalStateException("Genre already listed");
            }
            genre.setGenreName(genreName);
        }

        if (description != null && description.length() > 0 &&
                !Objects.equals(genre.getDescription(), description)) {
            genre.setDescription(description);
        }

        if (likeRate != null && likeRate >= 0.0 &&
                !Objects.equals(genre.getLikeRate(), likeRate)) {
            genre.setLikeRate(likeRate);
        }
    }
}
