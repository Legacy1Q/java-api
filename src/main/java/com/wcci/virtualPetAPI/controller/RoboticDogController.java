package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/roboticDogs")
    public List<RoboticDog> findAllRoboticDogs() {
        return this.roboticDogService.getAllRoboticDogs();
    }

    @GetMapping("/roboticDog/{id}")
    public RoboticDog findRoboticDogById(@PathVariable long id) {
        return this.roboticDogService.getRoboticDogById(id);
    }

    @GetMapping("/roboticDogs/{name}")
    public List<RoboticDog> findRoboticDogsByName(@PathVariable String name) {
        return this.roboticDogService.getRoboticDogsByName(name);
    }

    @PostMapping("/addRoboticDog")
    public void addRoboticDog(@RequestBody RoboticDog roboticDog) {
        this.roboticDogService.addRoboticDog(roboticDog);
    }

    @PutMapping("/roboticDog/{id}")
    public RoboticDog modifyRoboticDog(@PathVariable long id, @RequestBody RoboticDog updatedRoboticDog) {
        return this.roboticDogService.updateRoboticDog(id, updatedRoboticDog);
    }

    @DeleteMapping("/deleteRoboticDog/{id}")
    public void removePet(@PathVariable long id) {
        this.roboticDogService.deleteRoboticDog(id);
    }
}
