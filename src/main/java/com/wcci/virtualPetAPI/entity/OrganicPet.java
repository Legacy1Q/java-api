package com.wcci.virtualPetAPI.entity;

public abstract class OrganicPet extends VirtualPet {
    private boolean hunger;
    private boolean thirst;
    private boolean tiredness;
    private boolean boredom;
    private boolean sickness;

    public OrganicPet() {
    }

    public OrganicPet(String name) {
        super();
        this.setName(name);
        this.setHealth(false);
        this.setHappiness(false);
        this.hunger = false;
        this.thirst = false;
        this.tiredness = false;
        this.boredom = false;
        this.sickness = false;
    }

    public OrganicPet(String name, boolean health, boolean happiness, boolean hunger, boolean thirst, boolean tiredness,
            boolean boredom, boolean sickness) {
        super();
        this.setName(name);
        this.setHealth(health);
        this.setHappiness(happiness);
        this.setHunger(hunger);
        this.setThirst(thirst);
        this.setTiredness(tiredness);
        this.setBoredom(boredom);
        this.setSickness(sickness);
    }

    public boolean getHunger() {
        return this.hunger;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public boolean getThirst() {
        return this.thirst;
    }

    public void setThirst(boolean thirst) {
        this.thirst = thirst;
    }

    public boolean getTiredness() {
        return this.tiredness;
    }

    public void setTiredness(boolean tiredness) {
        this.tiredness = tiredness;
    }

    public boolean getBoredom() {
        return this.boredom;
    }

    public void setBoredom(boolean boredom) {
        this.boredom = boredom;
    }

    public boolean getSickness() {
        return this.sickness;
    }

    public void setSickness(boolean sickness) {
        this.sickness = sickness;
    }
}
