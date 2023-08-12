package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.service.RoboticCatService;

@RestController
public class RoboticCatController {

    @Autowired
    RoboticCatService roboticCatService;


    @PostMapping("/addRoboticCat")
    public void addRoboticCat(@RequestBody RoboticCat roboticCat) {
        this.roboticCatService.addRoboticCat(roboticCat);
    }

    @GetMapping("/roboticCat")
    public List<RoboticCat> findAllRoboticCats() {
        return this.roboticCatService.getAllRoboticCats();
    }

    @PutMapping("/roboticCat/{id}")
    public void modifyRoboticCat(@PathVariable long id, @RequestBody RoboticCat updatedPet) {
        this.roboticCatService.updatedRoboticCat(id, updatedPet);
    }

}

