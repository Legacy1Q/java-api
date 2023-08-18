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

import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.service.RoboticCatService;

@RestController
public class RoboticCatController {

    @Autowired
    RoboticCatService roboticCatService;

    @GetMapping("/roboticCats")
    public List<RoboticCat> findAllRoboticCats() {
        return this.roboticCatService.getAllRoboticCats();
    }

    @GetMapping("/roboticCat/{id}")
    public RoboticCat findRoboticCatById(@PathVariable long id) {
        return this.roboticCatService.getRoboticCatById(id);
    }

    @GetMapping("/roboticCats/{name}")
    public List<RoboticCat> findRoboticCatsByName(@PathVariable String name) {
        return this.roboticCatService.getRoboticCatsByName(name);
    }

    @PostMapping("/addRoboticCat")
    public void addRoboticCat(@RequestBody RoboticCat roboticCat) {
        this.roboticCatService.addRoboticCat(roboticCat);
    }

    @PutMapping("/roboticCat/{id}")
    public RoboticCat modifyRoboticCat(@PathVariable long id, @RequestBody RoboticCat updatedRoboticCat) {
        return this.roboticCatService.updateRoboticCat(id, updatedRoboticCat);
    }

    @DeleteMapping("/deleteRoboticCat/{id}")
    public void removeRoboticCat(@PathVariable long id) {
        this.roboticCatService.deleteRoboticCat(id);
    }
}
