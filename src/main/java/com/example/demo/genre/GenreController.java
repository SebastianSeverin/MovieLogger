package com.example.demo.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movieLogger/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDTO> getActor() {
        return genreService.getGenres();
    }

    @PostMapping
    public void registerNewGenre(@RequestBody Genre genre) {
        genreService.addNewGenre(genre);
    }

    @DeleteMapping(path = "{genreId}")
    public void deleteGenre(@PathVariable("genreId") Long genreId) {
        genreService.deleteGenre(genreId);
    }

    @PutMapping(path = "{genreId}")
    public void updateGenre(
            @PathVariable("genreId") Long genreId,
            @RequestParam(required = false) String genreName,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double likeRate) {
        genreService.updateGenre(genreId, genreName, description, likeRate);
    }
}
