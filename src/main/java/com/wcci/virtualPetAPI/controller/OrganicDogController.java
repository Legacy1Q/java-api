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

import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.service.OrganicDogService;

@RestController
public class OrganicDogController {

    @Autowired
    OrganicDogService organicDogService;

    @GetMapping("/organicDogs")
    public List<OrganicDog> findAllOrganicDogs() {
        return this.organicDogService.getAllOrganicDogs();
    }

    @GetMapping("/organicDog/{id}")
    public OrganicDog findOrganicDogById(@PathVariable long id) {
        return this.organicDogService.getOrganicDogById(id);
    }

    @GetMapping("/organicDogs/{name}")
    public List<OrganicDog> findOrganicDogsByName(@PathVariable String name) {
        return this.organicDogService.getOrganicDogsByName(name);
    }

    @PostMapping("/addOrganicDog")
    public void addOrganicDog(@RequestBody OrganicDog organicDog) {
        this.organicDogService.addOrganicDog(organicDog);
    }

    @PutMapping("/organicDog/{id}")
    public OrganicDog modifyOrganicDog(@PathVariable long id, @RequestBody OrganicDog updatedOrganicDog) {
        return this.organicDogService.updateOrganicDog(id, updatedOrganicDog);
    }

    @DeleteMapping("/deleteOrganicDog/{id}")
    public void removePet(@PathVariable long id) {
        this.organicDogService.deleteOrganicDog(id);
    }
}
