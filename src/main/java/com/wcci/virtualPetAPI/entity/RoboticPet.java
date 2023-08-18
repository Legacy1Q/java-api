package com.wcci.virtualPetAPI.entity;

public abstract class RoboticPet extends VirtualPet {

    private boolean oilLevel;
    private boolean maintenance;

    public RoboticPet() {
    }

    public RoboticPet(String name) {
        super();
        this.setName(name);
        this.oilLevel = false;
        this.maintenance = false;
        this.setHealth(false);
        this.setHappiness(false);
    }

    public RoboticPet(String name, boolean health, boolean happiness, boolean oilLevel, boolean maintenance) {
        super();
        this.setName(name);
        this.setHealth(health);
        this.setHappiness(happiness);
        this.setOilLevel(oilLevel);
        this.setMaintenance(maintenance);
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
