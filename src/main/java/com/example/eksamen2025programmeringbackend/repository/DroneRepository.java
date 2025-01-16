package com.example.eksamen2025programmeringbackend.repository;

import com.example.eksamen2025programmeringbackend.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {

}
