package com.example.eksamen2025programmeringbackend.repository;

import com.example.eksamen2025programmeringbackend.model.Levering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeveringRepository extends JpaRepository<Levering, Integer> {
}
