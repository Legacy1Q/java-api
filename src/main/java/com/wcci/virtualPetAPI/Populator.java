package com.wcci.virtualPetAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.VirtualPetShelter;
import com.wcci.virtualPetAPI.entity.Volunteer;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.entity.RoboticDog;
import com.wcci.virtualPetAPI.repository.VirtualPetRepository;
import com.wcci.virtualPetAPI.repository.VirtualPetShelterRepository;
import com.wcci.virtualPetAPI.repository.VolunteerRepository;

@Component
public class Populator implements CommandLineRunner {

        @Autowired
        private VirtualPetRepository virtualPetRepository;

        @Autowired
        private VirtualPetShelterRepository virtualPetShelterRepository;

        @Autowired
        private VolunteerRepository volunteerRepository;

        @Override
        public void run(String... args) throws Exception {

                Volunteer volunteer = new Volunteer("Bob");
                volunteerRepository.save(volunteer);

                Volunteer volunteer2 = new Volunteer("Bob2");
                volunteerRepository.save(volunteer2);

                List<Volunteer> volunteers = Arrays.asList(volunteer, volunteer2);

                OrganicCat organicCat = new OrganicCat("Orgcat", false, false, false, false, false,
                                false,
                                false,
                                false);
                virtualPetRepository.save(organicCat);

                OrganicCat organicCat2 = new OrganicCat("Orgcat2", false, false, false, false, false,
                                false,
                                false,
                                false);
                virtualPetRepository.save(organicCat2);

                List<OrganicCat> organicCats = Arrays.asList(organicCat, organicCat2);

                OrganicDog organicDog = new OrganicDog("Orgdog", false, false, false, false,
                                false, false, false, false, false);
                virtualPetRepository.save(organicDog);

                List<OrganicDog> organicDogs = Arrays.asList(organicDog);

                RoboticCat roboticCat = new RoboticCat("Robocat",
                                false, false, false, false);
                virtualPetRepository.save(roboticCat);

                RoboticDog roboticDog = new RoboticDog("Robodog",
                                false, false, false, false);
                virtualPetRepository.save(roboticDog);

                VirtualPetShelter shelter = new VirtualPetShelter("Test", "QWE");
                virtualPetShelterRepository.save(shelter);

                VirtualPetShelter virtualPetShelter = new VirtualPetShelter("Big Al's shelter",
                                "Pet shelter in town", organicCats, organicDogs, null, null, volunteers);
                virtualPetShelterRepository.save(virtualPetShelter);
        }
}
