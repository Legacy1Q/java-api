package com.wcci.virtualPetAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcci.virtualPetAPI.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
