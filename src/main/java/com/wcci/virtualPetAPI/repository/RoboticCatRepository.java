package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcci.virtualPetAPI.entity.RoboticCat;

public interface RoboticCatRepository extends JpaRepository<RoboticCat, Long> {

}
