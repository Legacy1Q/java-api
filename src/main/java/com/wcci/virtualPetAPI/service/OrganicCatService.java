package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.repository.OrganicCatRepository;

@Service
public class OrganicCatService {

    @Autowired
    private OrganicCatRepository organicCatRepository;

    public List<OrganicCat> getAllOrganicCats() {
        return this.organicCatRepository.findAll();
    }

    public OrganicCat getOrganicCatById(long id) {
        return this.organicCatRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Organic cat with id " + id + " was not found!"));
    }

    public void addOrganicCat(OrganicCat organicCat) {
        organicCat.setDescription("Organic Cat");
        this.organicCatRepository.save(organicCat);
    }

    public OrganicCat updateOrganicCat(long id, OrganicCat updatedOrganicCat) {
        OrganicCat existingOrganicCat = getOrganicCatById(id);
        existingOrganicCat.setName(
                updatedOrganicCat.getName() == null ? existingOrganicCat.getName() : updatedOrganicCat.getName());
        existingOrganicCat.setHealth(updatedOrganicCat.getHealth());
        existingOrganicCat.setHappiness(updatedOrganicCat.getHappiness());
        existingOrganicCat.setBoredom(updatedOrganicCat.getBoredom());
        existingOrganicCat.setHunger(updatedOrganicCat.getHunger());
        existingOrganicCat.setSickness(updatedOrganicCat.getSickness());
        existingOrganicCat.setThirst(updatedOrganicCat.getThirst());
        existingOrganicCat.setTiredness(updatedOrganicCat.getTiredness());
        OrganicCat.setLitterBox(OrganicCat.getLitterBox());
        this.organicCatRepository.save(existingOrganicCat);
        return existingOrganicCat;
    }

    public void deleteOrganicCat(long id) {
        this.organicCatRepository.deleteById(id);
    }
}
