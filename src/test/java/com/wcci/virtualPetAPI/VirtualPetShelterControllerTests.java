package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.VirtualPetShelterController;
import com.wcci.virtualPetAPI.entity.VirtualPetShelter;

@SpringBootTest
class VirtualPetShelterControllerTests {

    @Autowired
    private VirtualPetShelterController virtualPetShelterController;

    @Test
    void shouldReturnIdOfVirtualPetShelter() {
        long id = virtualPetShelterController.findShelterById(1).getId();
        assertEquals(1, id, "Mismatch Id of Virtual pet shelter!");
    }

    @Test
    void shouldAddVirtualPetShelter() {
        int oldTotal = virtualPetShelterController.findAllShelters().size();
        virtualPetShelterController.addShelter(new VirtualPetShelter("Test", "Description"));
        int newTotal = virtualPetShelterController.findAllShelters().size();
        assertEquals(oldTotal + 1, newTotal,
                "Virtual pet shelter was not added!");
    }

    @Test
    void shouldUpdateVirtualPetShelter() {
        VirtualPetShelter virtualPetShelter = virtualPetShelterController.findShelterById(1);
        virtualPetShelter.setName("Test123");
        String name = virtualPetShelterController.modifyShelter(1, virtualPetShelter).getName();
        assertEquals("Test123", name, "Virtual pet shelter was not updated!");
    }

    @Test
    void shouldDeleteVirtualPetShelter() {
        int oldTotal = virtualPetShelterController.findAllShelters().size();
        virtualPetShelterController.removeShelter(2);
        int newTotal = virtualPetShelterController.findAllShelters().size();
        assertEquals(oldTotal - 1, newTotal, "Virtual pet shelter was not deleted!");
    }
}
