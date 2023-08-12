package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.entity.RoboticDog;
import com.wcci.virtualPetAPI.entity.VirtualPet;
import com.wcci.virtualPetAPI.repository.VirtualPetRepository;
import com.wcci.virtualPetAPI.repository.VirtualPetShelterRepository;

@Service
public class VirtualPetService {
    
    @Autowired
    private VirtualPetRepository virtualPetRepository;

    @Autowired
    private VirtualPetShelterRepository virtualPetShelterRepository; //Another repository is autowired here.

    public List<VirtualPet> getAllVirtualPets() {
        return this.virtualPetRepository.findAll();
    }

    public VirtualPet getVirtualPetById(long id) {
        return this.virtualPetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Virtual pet with id " + id + " was not found!"));
    }

    public void addOrganicCat(OrganicCat organicCat) {
        this.virtualPetRepository.save(organicCat);
    }

    public void addOrganicDog(OrganicDog organicDog) {
        this.virtualPetRepository.save(organicDog);
    }

    public void addRoboticCat(RoboticCat roboticCat) {
        this.virtualPetRepository.save(roboticCat);
    }

    public void addRoboticDog(RoboticDog roboticDog) {
        this.virtualPetRepository.save(roboticDog);
    }

    public void updateVirtualPet(long id, VirtualPet updatedVirtualPet) {
        VirtualPet existingVirtualPet = this.virtualPetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Virtual pet with id " + id + " was not found!"));

        existingVirtualPet.setName(updatedVirtualPet.getName());
        existingVirtualPet.setDescription(updatedVirtualPet.getDescription());
        existingVirtualPet.setHealth(updatedVirtualPet.getHealth());
        existingVirtualPet.setHappiness(updatedVirtualPet.getHappiness());
    }

    public void deleteVirtualPet(long id) {
        this.virtualPetRepository.deleteById(id);
    }

}
