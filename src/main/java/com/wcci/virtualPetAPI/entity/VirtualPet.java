package com.wcci.virtualPetAPI.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class VirtualPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String name;
    private String description;
    private boolean health;
    private boolean happiness;

    public VirtualPet() {
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

    public boolean isHealth() {
        return this.health;
    }

    public boolean isHappiness() {
        return this.happiness;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
