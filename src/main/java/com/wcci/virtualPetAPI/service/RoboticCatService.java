package com.wcci.virtualPetAPI.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.repository.RoboticCatRepository;


@Service
public class RoboticCatService{

    @Autowired
    private RoboticCatRepository roboticCatRepository;


    public void addRoboticCat(RoboticCat roboticCat) {
        this.roboticCatRepository.save(roboticCat);
    }

    public List<RoboticCat> getAllRoboticCats() {
        return this.roboticCatRepository.findAll();
    }

    public void updatedRoboticCat(long id, RoboticCat updatedRoboticCat) {
        RoboticCat existingRoboticCat = this.roboticCatRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Virtual pet with id " + id + " was not found!"));

        existingRoboticCat.setName(updatedRoboticCat.getName());
        existingRoboticCat.setDescription(updatedRoboticCat.getDescription());
        existingRoboticCat.setHealth(updatedRoboticCat.getHealth());
        existingRoboticCat.setHappiness(updatedRoboticCat.getHappiness());
        this.roboticCatRepository.save(existingRoboticCat);
    }



}
