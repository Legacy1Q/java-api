package com.wcci.virtualPetAPI.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.RoboticDog;
import com.wcci.virtualPetAPI.repository.RoboticDogRepository;


@Service
public class RoboticDogService{

    @Autowired
    private RoboticDogRepository roboticDogRepository;


    public void addRoboticDog(RoboticDog roboticDog) {
        this.roboticDogRepository.save(roboticDog);
    }

    public List<RoboticDog> getAllRoboticDogs() {
        return this.roboticDogRepository.findAll();
    }

    public void updatedRoboticDog(long id, RoboticDog updatedRoboticDog) {
        RoboticDog existingRoboticDog = this.roboticDogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Virtual pet with id " + id + " was not found!"));

        existingRoboticDog.setName(updatedRoboticDog.getName());
        existingRoboticDog.setDescription(updatedRoboticDog.getDescription());
        existingRoboticDog.setHealth(updatedRoboticDog.getHealth());
        existingRoboticDog.setHappiness(updatedRoboticDog.getHappiness());
        this.roboticDogRepository.save(existingRoboticDog);
    }



}