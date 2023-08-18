package com.wcci.virtualPetAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.RoboticDog;
import com.wcci.virtualPetAPI.repository.RoboticDogRepository;

@Service
public class RoboticDogService {

    @Autowired
    private RoboticDogRepository roboticDogRepository;

    public List<RoboticDog> getAllRoboticDogs() {
        return this.roboticDogRepository.findAll();
    }

    public RoboticDog getRoboticDogById(long id) {
        return this.roboticDogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Robotic dog with id " + id + " was not found!"));
    }

    public List<RoboticDog> getRoboticDogsByName(String name) {
        List<RoboticDog> allRoboticDogs = getAllRoboticDogs();
        List<RoboticDog> roboticDogsByName = new ArrayList<>();
        for (RoboticDog roboticDog : allRoboticDogs) {
            if (roboticDog.getName().equals(name)) {
                roboticDogsByName.add(roboticDog);
            }
        }
        return roboticDogsByName;
    }

    public void addRoboticDog(RoboticDog roboticDog) {
        roboticDog.setDescription("Robotic Dog");
        this.roboticDogRepository.save(roboticDog);
    }

    public RoboticDog updateRoboticDog(long id, RoboticDog updatedRoboticDog) {
        RoboticDog existingRoboticDog = getRoboticDogById(id);
        existingRoboticDog.setName(
                updatedRoboticDog.getName() == null ? existingRoboticDog.getName() : updatedRoboticDog.getName());
        existingRoboticDog.setHealth(updatedRoboticDog.getHealth());
        existingRoboticDog.setHappiness(updatedRoboticDog.getHappiness());
        existingRoboticDog.setMaintenance(updatedRoboticDog.getMaintenance());
        existingRoboticDog.setOilLevel(updatedRoboticDog.getOilLevel());
        this.roboticDogRepository.save(existingRoboticDog);
        return existingRoboticDog;
    }

    public void deleteRoboticDog(long id) {
        this.roboticDogRepository.deleteById(id);
    }
}
