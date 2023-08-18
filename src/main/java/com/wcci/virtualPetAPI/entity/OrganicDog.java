package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"organic_dog\"")

public class OrganicDog extends OrganicPet {

    private boolean waste = true;
    private boolean cageCleanliness = true;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organic_dog_shelter_id")
    private VirtualPetShelter virtualPetShelter;

    public OrganicDog() {
    }

    public OrganicDog(String name) {
        super(name);
        this.waste = false;
        this.cageCleanliness = false;
        this.setDescription("Organic Dog");
    }

    public OrganicDog(String name, boolean health, boolean happiness,
            boolean hunger, boolean thirst, boolean tiredness, boolean boredom, boolean sickness, boolean waste,
            boolean cageCleanliness) {
        super(name, health, happiness, hunger, thirst, tiredness, boredom, sickness);
        this.setDescription("Organic Dog");
        this.waste = waste;
        this.cageCleanliness = cageCleanliness;
        setCageCleanliness(cageCleanliness);
    }

    public boolean getWaste() {
        return this.waste;
    }

    public void setWaste(boolean waste) {
        this.waste = waste;
    }

    public boolean getCageCleanliness() {
        return this.cageCleanliness;
    }

    public void setCageCleanliness(boolean cageCleanliness) {
        this.cageCleanliness = cageCleanliness;
    }

    public boolean isWaste() {
        return this.waste;
    }

    public boolean isCageCleanliness() {
        return this.cageCleanliness;
    }
}
