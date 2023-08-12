package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entity.RoboticDog;

@Repository
public interface RoboticDogRepository extends JpaRepository<RoboticDog, Long> {

}
