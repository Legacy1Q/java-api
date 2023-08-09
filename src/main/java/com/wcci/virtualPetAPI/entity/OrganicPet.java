package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;

@Entity
public abstract class OrganicPet extends VirtualPet {
    private boolean hunger;
    private boolean thirst;
    private boolean tiredness;
    private boolean boredom;
    private boolean sickness;

    public OrganicPet() {
    }

    public OrganicPet(String name, long id) {
        super(name, id);
        this.hunger = true;
        this.thirst = true;
        this.tiredness = true;
        this.boredom = true;
        this.sickness = true;
    }

    public OrganicPet(String name, long id, boolean happiness, boolean hunger, boolean thirst, boolean tiredness,
            boolean boredom,
            boolean sickness) {
        super(name, id);
        this.hunger = hunger;
        this.thirst = thirst;
        this.tiredness = tiredness;
        this.boredom = boredom;
        this.sickness = sickness;
        this.setHappiness(happiness);
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
