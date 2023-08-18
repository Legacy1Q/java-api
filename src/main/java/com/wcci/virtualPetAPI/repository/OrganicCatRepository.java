package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcci.virtualPetAPI.entity.OrganicCat;

public interface OrganicCatRepository extends JpaRepository<OrganicCat, Long> {

}
