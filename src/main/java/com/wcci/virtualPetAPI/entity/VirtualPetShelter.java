package com.wcci.virtualPetAPI.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"shelter\"")
public class VirtualPetShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelter_id")
    private long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "organic_cat_shelter_id", referencedColumnName = "shelter_id")
    private List<OrganicCat> organicCats = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "organic_dog_shelter_id", referencedColumnName = "shelter_id")
    private List<OrganicDog> organicDogs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "robotic_cat_shelter_id", referencedColumnName = "shelter_id")
    private List<RoboticCat> roboticCats = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "robotic_dog_shelter_id", referencedColumnName = "shelter_id")
    private List<RoboticDog> roboticDogs = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "volunteer_shelter_id", referencedColumnName = "shelter_id")
    private List<Volunteer> volunteers = new ArrayList<>();

    public VirtualPetShelter() {
    }

    public VirtualPetShelter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public VirtualPetShelter(String name, String description, List<OrganicCat> organicCats,
            List<OrganicDog> organicDogs, List<RoboticCat> roboticCats, List<RoboticDog> roboticDogs,
            List<Volunteer> volunteers) {
        this.name = name;
        this.description = description;
        this.organicCats = organicCats;
        this.organicDogs = organicDogs;
        this.roboticCats = roboticCats;
        this.roboticDogs = roboticDogs;
        this.volunteers = volunteers;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrganicCat> getOrganicCats() {
        return this.organicCats;
    }

    public void setOrganicCats(List<OrganicCat> organicCats) {
        this.organicCats = organicCats;
    }

    public List<OrganicDog> getOrganicDogs() {
        return this.organicDogs;
    }

    public void setOrganicDogs(List<OrganicDog> organicDogs) {
        this.organicDogs = organicDogs;
    }

    public List<RoboticCat> getRoboticCats() {
        return this.roboticCats;
    }

    public void setRoboticCats(List<RoboticCat> roboticCats) {
        this.roboticCats = roboticCats;
    }

    public List<RoboticDog> getRoboticDogs() {
        return this.roboticDogs;
    }

    public void setRoboticDogs(List<RoboticDog> roboticDogs) {
        this.roboticDogs = roboticDogs;
    }

    public List<Volunteer> getVolunteers() {
        return this.volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

}
