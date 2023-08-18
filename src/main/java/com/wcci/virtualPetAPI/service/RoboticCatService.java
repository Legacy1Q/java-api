package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.repository.RoboticCatRepository;

@Service
public class RoboticCatService {

    @Autowired
    private RoboticCatRepository roboticCatRepository;

    public List<RoboticCat> getAllRoboticCats() {
        return this.roboticCatRepository.findAll();
    }

    public RoboticCat getRoboticCatById(long id) {
        return this.roboticCatRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Robotic cat with id " + id + " was not found!"));
    }

    public void addRoboticCat(RoboticCat roboticCat) {
        roboticCat.setDescription("Robotic Cat");
        this.roboticCatRepository.save(roboticCat);
    }

    public RoboticCat updateRoboticCat(long id, RoboticCat updatedRoboticCat) {
        RoboticCat existingRoboticCat = getRoboticCatById(id);
        existingRoboticCat.setName(
                updatedRoboticCat.getName() == null ? existingRoboticCat.getName() : updatedRoboticCat.getName());
        existingRoboticCat.setHealth(updatedRoboticCat.getHealth());
        existingRoboticCat.setHappiness(updatedRoboticCat.getHappiness());
        existingRoboticCat.setMaintenance(updatedRoboticCat.getMaintenance());
        existingRoboticCat.setOilLevel(updatedRoboticCat.getOilLevel());
        this.roboticCatRepository.save(existingRoboticCat);
        return existingRoboticCat;
    }

    public void deleteRoboticCat(long id) {
        this.roboticCatRepository.deleteById(id);
    }
}
