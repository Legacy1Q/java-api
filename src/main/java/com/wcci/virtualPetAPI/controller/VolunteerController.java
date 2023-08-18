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

import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.service.VolunteerService;

@RestController
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @GetMapping("/volunteers")
    public List<Volunteer> findAllVolunteers() {
        return this.volunteerService.getAllVolunteers();
    }

    @GetMapping("/volunteer/{id}")
    public Volunteer findVolunteerById(@PathVariable long id) {
        return this.volunteerService.getVolunteerById(id);
    }

    @GetMapping("/volunteers/{name}")
    public List<Volunteer> findVolunteersByName(@PathVariable String name) {
        return this.volunteerService.getVolunteersByName(name);
    }

    @PostMapping("/addVolunteer")
    public void addVolunteer(@RequestBody Volunteer volunteer) {
        this.volunteerService.addVolunteer(volunteer);
    }

    @PutMapping("/volunteer/{id}")
    public Volunteer modifyVolunteer(@PathVariable long id, @RequestBody Volunteer updatedVolunteer) {
        return this.volunteerService.updateVolunteer(id, updatedVolunteer);
    }

    @DeleteMapping("/deleteVolunteer/{id}")
    public void removeVolunteer(@PathVariable long id) {
        this.volunteerService.deleteVolunteer(id);
    }
}
