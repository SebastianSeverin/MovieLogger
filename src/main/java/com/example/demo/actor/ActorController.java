package com.example.demo.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movieLogger/actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<ActorDTO> getActor() {
        return actorService.getActors();
    }

    @PostMapping
    public void registerNewActor(@RequestBody Actor actor) {
        actorService.addNewActor(actor);
    }

    @DeleteMapping(path = "{actorId}")
    public void deleteActor(@PathVariable("actorId") Long actorId) {
        actorService.deleteActor(actorId);
    }

    @PutMapping(path = "{actorId}")
    public void updateActor(
            @PathVariable("actorId") Long actorId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Integer numberOfAwards) {
        actorService.updateActor(actorId, firstName, lastName, age, numberOfAwards);
    }
}
