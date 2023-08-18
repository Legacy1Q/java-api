package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"robotic_cat\"")

public class RoboticCat extends RoboticPet {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "robotic_cat_shelter_id")
    private VirtualPetShelter virtualPetShelter;

    public RoboticCat() {
    }

    public RoboticCat(String name) {
        super(name);
        this.setDescription("Robotic Cat");
    }

    public RoboticCat(String name, boolean health, boolean happiness,
            boolean oilLevel, boolean maintenance) {
        super(name, health, happiness, oilLevel, maintenance);
        this.setDescription("Robotic Cat");
    }
}
