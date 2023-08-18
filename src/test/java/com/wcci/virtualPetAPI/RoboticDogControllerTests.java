package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.RoboticDogController;
import com.wcci.virtualPetAPI.entity.RoboticDog;

@SpringBootTest
class RoboticDogControllerTests {

    @Autowired
    private RoboticDogController roboticDogController;

    @Test
    void shouldReturnIdOfRoboticDog() {
        long id = roboticDogController.findRoboticDogById(7).getId();
        assertEquals(7, id, "Mismatch Id of robotic dog!");
    }

    @Test
    void shouldReturnNameOfRoboticDog() {
        String name = roboticDogController.findRoboticDogById(7).getName();
        assertEquals("Robodog", name, "Name does not match!");
    }

    @Test
    void shouldAddRoboticDog() {
        int oldTotal = roboticDogController.findAllRoboticDogs().size();
        roboticDogController.addRoboticDog(new RoboticDog("Test"));
        int newTotal = roboticDogController.findAllRoboticDogs().size();
        assertEquals(oldTotal + 1, newTotal,
                "Robotic dog was not added!");
    }

    @Test
    void shouldUpdateRoboticDog() {
        RoboticDog roboticDog = roboticDogController.findRoboticDogById(7);
        roboticDog.setName("Test");
        String name = roboticDogController.modifyRoboticDog(7, roboticDog).getName();
        assertEquals("Test", name, "Robotic dog was not updated!");
    }

    @Test
    void shouldDeleteRoboticDog() {
        int oldTotal = roboticDogController.findAllRoboticDogs().size();
        roboticDogController.removeRoboticDog(8);
        int newTotal = roboticDogController.findAllRoboticDogs().size();
        assertEquals(oldTotal - 1, newTotal, "Robotic dog was not deleted!");
    }
}
