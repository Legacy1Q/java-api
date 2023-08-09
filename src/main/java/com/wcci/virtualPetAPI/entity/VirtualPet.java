package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"pet\"")
public abstract class VirtualPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private boolean health;
    private boolean happiness;

    public VirtualPet() {
    }

    public VirtualPet(String name, long id) {
        this.id = id;
        this.name = name;
        this.happiness = true;
        this.health = true;
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

    public boolean getHealth() {
        return this.health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public boolean getHappiness() {
        return this.happiness;
    }

    public void setHappiness(boolean happiness) {
        this.happiness = happiness;
    }
}
