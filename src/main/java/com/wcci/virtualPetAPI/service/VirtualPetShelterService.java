package com.wcci.virtualPetAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.VirtualPetShelter;
import com.wcci.virtualPetAPI.repository.VirtualPetShelterRepository;

@Service
public class VirtualPetShelterService {

    @Autowired
    private VirtualPetShelterRepository virtualPetShelterRepository;

    public List<VirtualPetShelter> getAllShelters() {
        return this.virtualPetShelterRepository.findAll();
    }

    public VirtualPetShelter getShelterById(long id) {
        return this.virtualPetShelterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Virtual pet shelter with id " + id + " was not found!"));
    }

    public List<VirtualPetShelter> getVirtualPetSheltersByName(String name) {
        List<VirtualPetShelter> allVirtualPetShelters = getAllShelters();
        List<VirtualPetShelter> virtualPetSheltersByName = new ArrayList<>();
        for (VirtualPetShelter virtualPetShelter : allVirtualPetShelters) {
            if (virtualPetShelter.getName().equals(name)) {
                virtualPetSheltersByName.add(virtualPetShelter);
            }
        }
        return virtualPetSheltersByName;
    }

    public void deleteShelter(long id) {
        this.virtualPetShelterRepository.deleteById(id);
    }

    public void addShelter(VirtualPetShelter virtualPetShelter) {
        this.virtualPetShelterRepository.save(virtualPetShelter);
    }

    public VirtualPetShelter updateShelter(long id, VirtualPetShelter updatedVirtualPetShelter) {
        VirtualPetShelter existingVirtualPetShelter = getShelterById(id);
        existingVirtualPetShelter
                .setName(updatedVirtualPetShelter.getName() == null ? existingVirtualPetShelter.getName()
                        : updatedVirtualPetShelter.getName());
        existingVirtualPetShelter.setDescription(
                updatedVirtualPetShelter.getDescription() == null ? existingVirtualPetShelter.getDescription()
                        : updatedVirtualPetShelter.getDescription());
        existingVirtualPetShelter.setOrganicCats(updatedVirtualPetShelter.getOrganicCats());
        existingVirtualPetShelter.setOrganicDogs(updatedVirtualPetShelter.getOrganicDogs());
        existingVirtualPetShelter.setRoboticCats(updatedVirtualPetShelter.getRoboticCats());
        existingVirtualPetShelter.setRoboticDogs(updatedVirtualPetShelter.getRoboticDogs());
        existingVirtualPetShelter.setVolunteers(updatedVirtualPetShelter.getVolunteers());
        this.virtualPetShelterRepository.save(existingVirtualPetShelter);
        return existingVirtualPetShelter;
    }

}
