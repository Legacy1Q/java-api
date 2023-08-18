package com.wcci.virtualPetAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public List<Volunteer> getAllVolunteers() {
        return this.volunteerRepository.findAll();
    }

    public Volunteer getVolunteerById(long id) {
        return this.volunteerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Volunteer with id " + id + " was not found!"));
    }

    public List<Volunteer> getVolunteersByName(String name) {
        List<Volunteer> allVolunteers = getAllVolunteers();
        List<Volunteer> volunteersByName = new ArrayList<>();
        for (Volunteer volunteer : allVolunteers) {
            if (volunteer.getName().equals(name)) {
                volunteersByName.add(volunteer);
            }
        }
        return volunteersByName;
    }

    public void addVolunteer(Volunteer volunteer) {
        this.volunteerRepository.save(volunteer);
    }

    public Volunteer updateVolunteer(long id, Volunteer updatedVolunteer) {
        Volunteer existingVolunteer = getVolunteerById(id);
        existingVolunteer
                .setName(updatedVolunteer.getName() == null ? existingVolunteer.getName() : updatedVolunteer.getName());
        this.volunteerRepository.save(existingVolunteer);
        return existingVolunteer;
    }

    public void deleteVolunteer(long id) {
        this.volunteerRepository.deleteById(id);
    }
}
