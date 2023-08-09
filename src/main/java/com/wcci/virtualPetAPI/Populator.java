package com.wcci.virtualPetAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.virtualPetAPI.entity.OrganicCat;
import com.wcci.virtualPetAPI.entity.OrganicDog;
import com.wcci.virtualPetAPI.entity.RoboticCat;
import com.wcci.virtualPetAPI.entity.RoboticDog;
import com.wcci.virtualPetAPI.repository.VirtualPetRepository;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private VirtualPetRepository virtualPetRepository;

    @Override
    public void run(String... args) throws Exception {

        OrganicCat organicCat = new OrganicCat("Orgcat", 1);
        virtualPetRepository.save(organicCat);

        OrganicDog organicDog = new OrganicDog("Orgdog", 2, false, false, false, false, false, false);
        virtualPetRepository.save(organicDog);

        RoboticCat roboticCat = new RoboticCat("Robocat", 3, false, false, false);
        virtualPetRepository.save(roboticCat);

        RoboticDog roboticDog = new RoboticDog("Robodog", 4, false, false, false);
        virtualPetRepository.save(roboticDog);
    }
}
