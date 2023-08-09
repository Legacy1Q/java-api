package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;

@Entity
public class RoboticDog extends RoboticPet {

    public RoboticDog() {
    }

    public RoboticDog(String name, long id) {
        super(name, id);
        this.setDescription("Robotic Dog");
    }

    public RoboticDog(String name, long id, boolean happiness, boolean oilLevel, boolean maintenance) {
        super(name, id, happiness, oilLevel, maintenance);
        this.setDescription("Robotic Dog");
    }
}