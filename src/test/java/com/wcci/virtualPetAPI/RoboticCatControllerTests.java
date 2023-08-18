package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.RoboticCatController;
import com.wcci.virtualPetAPI.entity.RoboticCat;

@SpringBootTest
class RoboticCatControllerTests {

    @Autowired
    private RoboticCatController roboticCatController;

    @Test
    void shouldReturnIdOfRoboticCat() {
        long id = roboticCatController.findRoboticCatById(5).getId();
        assertEquals(5, id, "Mismatch Id of robotic cat!");
    }

    @Test
    void shouldReturnNameOfRoboticCat() {
        String name = roboticCatController.findRoboticCatById(5).getName();
        assertEquals("Robocat", name, "Name does not match!");
    }

    @Test
    void shouldAddRoboticCat() {
        int oldTotal = roboticCatController.findAllRoboticCats().size();
        roboticCatController.addRoboticCat(new RoboticCat("Test"));
        int newTotal = roboticCatController.findAllRoboticCats().size();
        assertEquals(oldTotal + 1, newTotal,
                "Robotic cat was not added!");
    }

    @Test
    void shouldUpdateRoboticCat() {
        RoboticCat roboticCat = roboticCatController.findRoboticCatById(5);
        roboticCat.setName("Test");
        String name = roboticCatController.modifyRoboticCat(5, roboticCat).getName();
        assertEquals("Test", name, "Robotic cat was not updated!");
    }

    @Test
    void shouldDeleteRoboticCat() {
        int oldTotal = roboticCatController.findAllRoboticCats().size();
        roboticCatController.removeRoboticCat(6);
        int newTotal = roboticCatController.findAllRoboticCats().size();
        assertEquals(oldTotal - 1, newTotal, "Robotic cat was not deleted!");
    }
}
