package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entity.VirtualPet;

@Repository
public interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {

}
