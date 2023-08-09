package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;

@Entity
public abstract class RoboticPet extends VirtualPet {

    private boolean oilLevel;
    private boolean maintenance;

    public RoboticPet() {
    }

    public RoboticPet(String name, long id) {
        super(name, id);
        this.oilLevel = true;
        this.maintenance = true;
    }

    public RoboticPet(String name, long id, boolean happiness, boolean oilLevel, boolean maintenance) {
        super(name, id);
        this.oilLevel = oilLevel;
        this.maintenance = maintenance;
    }

    public boolean getOilLevel() {
        return this.oilLevel;
    }

    public void setOilLevel(boolean oilLevel) {
        this.oilLevel = oilLevel;
    }

    public boolean getMaintenance() {
        return this.maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }
}
