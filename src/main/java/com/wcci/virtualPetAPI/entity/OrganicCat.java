package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"organic_cat\"")

public class OrganicCat extends OrganicPet {

    private static boolean litterBox = true;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organic_cat_shelter_id")
    private VirtualPetShelter virtualPetShelter;

    public OrganicCat() {
    }

    public OrganicCat(String name) {
        super(name);
        OrganicCat.litterBox = false;
        this.setDescription("Organic Cat");
    }

    public OrganicCat(String name, boolean health, boolean happiness,
            boolean hunger, boolean thirst, boolean tiredness, boolean boredom, boolean sickness, boolean litterBox) {
        super(name, health, happiness, hunger, thirst, tiredness, boredom, sickness);
        OrganicCat.litterBox = litterBox;
        this.setDescription("Organic Cat");
    }

    public static boolean getLitterBox() {
        return litterBox;
    }

    public static void setLitterBox(boolean newLitter) {
        litterBox = newLitter;
    }
}
