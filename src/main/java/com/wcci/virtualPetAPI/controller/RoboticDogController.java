package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entity.RoboticDog;
import com.wcci.virtualPetAPI.service.RoboticDogService;

@RestController
public class RoboticDogController {

    @Autowired
    RoboticDogService roboticDogService;


    @PostMapping("/addRoboticDog")
    public void addRoboticDog(@RequestBody RoboticDog roboticDog) {
        this.roboticDogService.addRoboticDog(roboticDog);
    }

    @GetMapping("/roboticDog")
    public List<RoboticDog> findAllRoboticDogs() {
        return this.roboticDogService.getAllRoboticDogs();
    }

    @PutMapping("/roboticDog/{id}")
    public void modifyRoboticDog(@PathVariable long id, @RequestBody RoboticDog updatedPet) {
        this.roboticDogService.updatedRoboticDog(id, updatedPet);
    }

}

