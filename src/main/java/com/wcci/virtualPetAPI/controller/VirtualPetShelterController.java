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

import com.wcci.virtualPetAPI.entity.VirtualPetShelter;
import com.wcci.virtualPetAPI.service.VirtualPetShelterService;

@RestController
public class VirtualPetShelterController {

    @Autowired
    VirtualPetShelterService virtualPetShelterService;

    @GetMapping("/shelters")
    public List<VirtualPetShelter> findAllShelters() {
        return this.virtualPetShelterService.getAllShelters();
    }

    @GetMapping("/shelter/{id}")
    public VirtualPetShelter findShelterById(@PathVariable long id) {
        return this.virtualPetShelterService.getShelterById(id);
    }

    @GetMapping("/shelters/{name}")
    public List<VirtualPetShelter> findSheltersByName(@PathVariable String name) {
        return this.virtualPetShelterService.getVirtualPetSheltersByName(name);
    }

    @PostMapping("/addShelter")
    public void addShelter(@RequestBody VirtualPetShelter virtualPetShelter) {
        this.virtualPetShelterService.addShelter(virtualPetShelter);
    }

    @PutMapping("/shelter/{id}")
    public VirtualPetShelter modifyShelter(@PathVariable long id, @RequestBody VirtualPetShelter updatedShelter) {
        return this.virtualPetShelterService.updateShelter(id, updatedShelter);
    }

    @DeleteMapping("/deleteShelter/{id}")
    public void removeShelter(@PathVariable long id) {
        this.virtualPetShelterService.deleteShelter(id);
    }
}
