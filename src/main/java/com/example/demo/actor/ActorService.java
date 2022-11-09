package com.example.demo.actor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorDTO> getActors() {
        return actorRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    public void addNewActor(Actor actor) {
        Optional<Actor> actorOptional = actorRepository.findActorByName(actor.getFirstName(), actor.getLastName());
        if (actorOptional.isPresent()) {
            throw new IllegalStateException("actor already registered");
        }
        actorRepository.save(actor);
    }

    public void deleteActor(Long actorId) {
        boolean exists = actorRepository.existsById(actorId);
        if (!exists) {
            throw new IllegalStateException("actor with id " + actorId + " does not exist!");
        }
        actorRepository.deleteById(actorId);
    }

    private ActorDTO convertEntityToDTO(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(actor.getActorId());
        actorDTO.setFirstName(actor.getFirstName());
        actorDTO.setLastName(actor.getLastName());
        actorDTO.setAge(actor.getAge());
        actorDTO.setNumberOfAwards(actor.getNumberOfAwards());
        actorDTO.setMovies(actor.getPortfolio());
        return actorDTO;
    }
    @Transactional
    public void updateActor(Long actorId, String firstName, String lastName, Integer age, Integer numberOfAwards) {
        Actor actor = actorRepository.findActorById(actorId)
                .orElseThrow(() -> new IllegalStateException(
                "Actor with id " + actorId + " does not exist!"
        ));

        if (firstName != null && firstName.length() > 0 &&
                !Objects.equals(actor.getFirstName(), firstName)) {
            actor.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 &&
                !Objects.equals(actor.getLastName(), lastName)) {
            actor.setLastName(lastName);
        }

        if (age != null && age > 0 &&
                !Objects.equals(actor.getAge(), age)) {
            actor.setAge(age);
        }

        if (numberOfAwards != null && numberOfAwards > 0 &&
                !Objects.equals(actor.getNumberOfAwards(), numberOfAwards)) {
            actor.setNumberOfAwards(numberOfAwards);
        }
    }
}
