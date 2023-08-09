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

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.VirtualPet;

import com.wcci.virtualPetAPI.service.VirtualPetService;

@RestController
public class VirtualPetController {

    @Autowired
    VirtualPetService virtualPetService;

    @GetMapping("/ping")
    public String pingping() {
        return "pong";
    }

    @PostMapping("/addPet")
    public void addVirtualPet(@RequestBody OrganicCat organicCat) {
        this.virtualPetService.addOrganicCat(organicCat);
    }

    @GetMapping("/pets")
    public List<VirtualPet> findAllVirtualPet() {
        return this.virtualPetService.getAllVirtualPets();
    }

    @GetMapping("/pet/{id}")
    public VirtualPet findPetById(@PathVariable long id) {
        return this.virtualPetService.getVirtualPetById(id);
    }

    @PutMapping("/pet/{id}")
    public void modifyPet(@PathVariable long id, @RequestBody VirtualPet updatedPet) {
        this.virtualPetService.updateVirtualPet(id, updatedPet);
    }

    @DeleteMapping("/deletePet/{id}")
    public void removePet(@PathVariable long id) {
        this.virtualPetService.deleteVirtualPet(id);
    }
}
