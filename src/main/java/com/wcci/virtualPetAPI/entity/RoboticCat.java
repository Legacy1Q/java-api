package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;

@Entity
public class RoboticCat extends RoboticPet {

    public RoboticCat() {
    }

    public RoboticCat(String name, long id) {
        super(name, id);
        this.setDescription("Robotic Cat");
    }

    public RoboticCat(String name, long id, boolean happiness, boolean oilLevel, boolean maintenance) {
        super(name, id, happiness, oilLevel, maintenance);
        this.setDescription("Robotic Cat");
    }
}
