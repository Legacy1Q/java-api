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
import com.wcci.virtualPetAPI.service.OrganicCatService;

@RestController
public class OrganicCatController {

    @Autowired
    OrganicCatService organicCatService;

    @GetMapping("/organicCats")
    public List<OrganicCat> findAllOrganicCats() {
        return this.organicCatService.getAllOrganicCats();
    }

    @GetMapping("/organicCat/{id}")
    public OrganicCat findOrganicCatById(@PathVariable long id) {
        return this.organicCatService.getOrganicCatById(id);
    }

    @GetMapping("/organicCats/{name}")
    public List<OrganicCat> findOrganicCatsByName(@PathVariable String name) {
        return this.organicCatService.getOrganicCatsByName(name);
    }

    @PostMapping("/addOrganicCat")
    public void addOrganicCat(@RequestBody OrganicCat organicCat) {
        this.organicCatService.addOrganicCat(organicCat);
    }

    @PutMapping("/organicCat/{id}")
    public OrganicCat modifyOrganicCat(@PathVariable long id, @RequestBody OrganicCat updatedOrganicCat) {
        return this.organicCatService.updateOrganicCat(id, updatedOrganicCat);
    }

    @DeleteMapping("/deleteOrganicCat/{id}")
    public void removeOrganicCat(@PathVariable long id) {
        this.organicCatService.deleteOrganicCat(id);
    }
}
