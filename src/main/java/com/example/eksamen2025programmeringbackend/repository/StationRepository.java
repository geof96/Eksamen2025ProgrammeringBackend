package com.example.eksamen2025programmeringbackend.repository;

import com.example.eksamen2025programmeringbackend.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
}
