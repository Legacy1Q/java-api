package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.OrganicCatController;
import com.wcci.virtualPetAPI.entity.OrganicCat;

@SpringBootTest
class OrganicCatControllerTests {

	@Autowired
	private OrganicCatController organicCatController;

	@Test
	void shouldReturnIdOfOrganicCat() {
		long id = organicCatController.findOrganicCatById(1).getId();
		assertEquals(1, id, "Mismatch Id of organic cat!");
	}

	@Test
	void shouldReturnNameOfOrganicCat() {
		String name = organicCatController.findOrganicCatById(1).getName();
		assertEquals("Orgcat", name, "Name does not match!");
	}

	@Test
	void shouldAddOrganicCat() {
		int oldTotal = organicCatController.findAllOrganicCats().size();
		organicCatController.addOrganicCat(new OrganicCat("Test"));
		int newTotal = organicCatController.findAllOrganicCats().size();
		assertEquals(oldTotal + 1, newTotal,
				"Organic cat was not added!");
	}

	@Test
	void shouldUpdateOrganicCat() {
		OrganicCat organicCat = organicCatController.findOrganicCatById(2);
		organicCat.setName("Test");
		String name = organicCatController.modifyOrganicCat(2, organicCat).getName();
		assertEquals("Test", name, "Organic cat was not updated!");
	}

	@Test
	void shouldDeleteOrganicCat() {
		int oldTotal = organicCatController.findAllOrganicCats().size();
		organicCatController.removeOrganicCat(1);
		int newTotal = organicCatController.findAllOrganicCats().size();
		assertEquals(oldTotal - 1, newTotal, "Organic cat was not deleted!");
	}
}
