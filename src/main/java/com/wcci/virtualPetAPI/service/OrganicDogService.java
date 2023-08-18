package com.wcci.virtualPetAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.repository.OrganicDogRepository;

@Service
public class OrganicDogService {

    @Autowired
    private OrganicDogRepository organicDogRepository;

    public List<OrganicDog> getAllOrganicDogs() {
        return this.organicDogRepository.findAll();
    }

    public OrganicDog getOrganicDogById(long id) {
        return this.organicDogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Organic dog with id " + id + " was not found!"));
    }

    public List<OrganicDog> getOrganicDogsByName(String name) {
        List<OrganicDog> allOrganicDogs = getAllOrganicDogs();
        List<OrganicDog> organicDogsByName = new ArrayList<>();
        for (OrganicDog organicDog : allOrganicDogs) {
            if (organicDog.getName().equals(name)) {
                organicDogsByName.add(organicDog);
            }
        }
        return organicDogsByName;
    }

    public void addOrganicDog(OrganicDog organicDog) {
        organicDog.setDescription("Organic Dog");
        this.organicDogRepository.save(organicDog);
    }

    public OrganicDog updateOrganicDog(long id, OrganicDog updatedOrganicDog) {
        OrganicDog existingOrganicDog = getOrganicDogById(id);
        existingOrganicDog.setName(
                updatedOrganicDog.getName() == null ? existingOrganicDog.getName() : updatedOrganicDog.getName());
        existingOrganicDog.setHealth(updatedOrganicDog.getHealth());
        existingOrganicDog.setHappiness(updatedOrganicDog.getHappiness());
        existingOrganicDog.setBoredom(updatedOrganicDog.getBoredom());
        existingOrganicDog.setCageCleanliness(updatedOrganicDog.getCageCleanliness());
        existingOrganicDog.setHunger(updatedOrganicDog.getHunger());
        existingOrganicDog.setSickness(updatedOrganicDog.getSickness());
        existingOrganicDog.setThirst(updatedOrganicDog.getThirst());
        existingOrganicDog.setTiredness(updatedOrganicDog.getTiredness());
        existingOrganicDog.setWaste(updatedOrganicDog.getWaste());
        this.organicDogRepository.save(existingOrganicDog);
        return existingOrganicDog;
    }

    public void deleteOrganicDog(long id) {
        this.organicDogRepository.deleteById(id);
    }
}
