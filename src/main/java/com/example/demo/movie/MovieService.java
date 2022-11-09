package com.example.demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getMovies() {
        return movieRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByName(movie.getName());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("movie already registered");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("movie with id " + movieId + " does not exist!");
        }
        movieRepository.deleteById(movieId);
    }

    private MovieDTO convertEntityToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setRating(movie.getRating());
        movieDTO.setLength(movie.getLength());
        movieDTO.setReleaseYear(movie.getReleaseYear());
        movieDTO.setGenreName(movie.getGenre().getGenreName());
        return movieDTO;
    }
    @Transactional
    public void updateMovie(Long movieId, String name, Integer length, Double rating, LocalDate releaseYear) {
        Movie movie = movieRepository.findMovieById(movieId)
                .orElseThrow(() -> new IllegalStateException(
                "Movie with id " + movieId + " does not exist!"
        ));

        if (name != null && name.length() > 0 &&
                !Objects.equals(movie.getName(), name)) {
            Optional<Movie> movieOptional = movieRepository.findMovieByName(name);
            if (movieOptional.isPresent()) {
                throw new IllegalStateException("Movie already listed");
            }
            movie.setName(name);
        }

        if (length != null && length >= 0.0 &&
                !Objects.equals(movie.getLength(), length)) {
            movie.setLength(length);
        }

        if (rating != null && rating >= 0.0 &&
                !Objects.equals(movie.getRating(), rating)) {
            movie.setRating(rating);
        }

        if (releaseYear != null &&
                !Objects.equals(movie.getReleaseYear(), releaseYear)) {
            movie.setReleaseYear(releaseYear);
        }
    }
}
