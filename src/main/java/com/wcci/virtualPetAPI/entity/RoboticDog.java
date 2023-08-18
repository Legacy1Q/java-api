package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"robotic_dog\"")

public class RoboticDog extends RoboticPet {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "robotic_dog_shelter_id")
    private VirtualPetShelter virtualPetShelter;

    public RoboticDog() {
    }

    public RoboticDog(String name) {
        super();
        this.setName(name);
        this.setDescription("Robotic Dog");
    }

    public RoboticDog(String name, boolean health, boolean happiness,
            boolean oilLevel, boolean maintenance) {
        super();
        this.setName(name);
        this.setHealth(health);
        this.setHappiness(happiness);
        this.setOilLevel(oilLevel);
        this.setMaintenance(maintenance);
        this.setDescription("Robotic Dog");
    }
}
