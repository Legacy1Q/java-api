package com.wcci.virtualPetAPI.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VirtualPetShelter {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @OneToMany()
    Map<String, VirtualPet> pets = new HashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPet(String name) {
        return pets.get(name);
    }

    public Set<String> getAllOrganicPetNames() {
        Set<String> petnames = new HashSet<String>();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                petnames.add(pet.getName());
            }
        }
        return petnames;
    }

    public void rescuePet(VirtualPet newPet) {
        pets.put(newPet.getName(), newPet);
    }

    public void adoptPet(String name) {
        pets.remove(name);
    }

}
