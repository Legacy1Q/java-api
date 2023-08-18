package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.VolunteerController;
import com.wcci.virtualPetAPI.entity.Volunteer;

@SpringBootTest
class VolunteerControllerTests {

    @Autowired
    private VolunteerController volunteerController;

    @Test
    void shouldReturnIdOfVolunteer() {
        long id = volunteerController.findVolunteerById(1).getId();
        assertEquals(1, id, "Mismatch Id of Volunteer!");
    }

    @Test
    void shouldAddVolunteer() {
        int oldTotal = volunteerController.findAllVolunteers().size();
        volunteerController.addVolunteer(new Volunteer("Test"));
        int newTotal = volunteerController.findAllVolunteers().size();
        assertEquals(oldTotal + 1, newTotal,
                "Volunteer was not added!");
    }

    @Test
    void shouldUpdateVolunteer() {
        Volunteer volunteer = volunteerController.findVolunteerById(1);
        volunteer.setName("Test");
        String name = volunteerController.modifyVolunteer(1, volunteer).getName();
        assertEquals("Test", name, "Volunteer was not updated!");
    }
}
