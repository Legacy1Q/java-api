package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.OrganicDogController;
import com.wcci.virtualPetAPI.entity.OrganicDog;

@SpringBootTest
class OrganicDogControllerTests {

    @Autowired
    private OrganicDogController organicDogController;

    @Test
    void shouldReturnIdOfOrganicDog() {
        long id = organicDogController.findOrganicDogById(3).getId();
        assertEquals(3, id, "Mismatch Id of organic dog!");
    }

    @Test
    void shouldReturnNameOfOrganicDog() {
        String name = organicDogController.findOrganicDogById(3).getName();
        assertEquals("Orgdog", name, "Name does not match!");
    }

    @Test
    void shouldAddOrganicDog() {
        int oldTotal = organicDogController.findAllOrganicDogs().size();
        organicDogController.addOrganicDog(new OrganicDog("Test"));
        int newTotal = organicDogController.findAllOrganicDogs().size();
        assertEquals(oldTotal + 1, newTotal,
                "Organic dog was not added!");
    }

    @Test
    void shouldUpdateOrganicDog() {
        OrganicDog organicDog = organicDogController.findOrganicDogById(3);
        organicDog.setName("Test");
        String name = organicDogController.modifyOrganicDog(3, organicDog).getName();
        assertEquals("Test", name, "Organic dog was not updated!");
    }

    @Test
    void shouldDeleteOrganicDog() {
        int oldTotal = organicDogController.findAllOrganicDogs().size();
        organicDogController.removeOrganicDog(4);
        int newTotal = organicDogController.findAllOrganicDogs().size();
        assertEquals(oldTotal - 1, newTotal, "Organic dog was not deleted!");
    }
}
