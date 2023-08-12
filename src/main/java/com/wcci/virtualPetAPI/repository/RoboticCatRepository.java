package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entity.RoboticCat;

@Repository
public interface RoboticCatRepository extends JpaRepository<RoboticCat, Long> {

}
