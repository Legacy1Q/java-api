package com.wcci.virtualPetAPI.entity;

import javax.persistence.Entity;

@Entity
public class OrganicCat extends OrganicPet {
    private static boolean litterBox = true;

    public OrganicCat() {
    }

    public OrganicCat(String name, long id) {
        super(name, id);
        this.setDescription("Organic Cat");
    }

    public OrganicCat(String name, long id, boolean happiness, boolean hunger, boolean thirst, boolean tiredness,
            boolean boredom, boolean sickness) {
        super(name, id, happiness, hunger, thirst, tiredness, boredom, sickness);
        this.setDescription("Organic Cat");
    }

    public static boolean getLitterBox() {
        return litterBox;
    }

    public static void setLitterBox(boolean newLitter) {
        litterBox = newLitter;
    }
}
