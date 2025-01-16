package com.example.eksamen2025programmeringbackend.repository;

import com.example.eksamen2025programmeringbackend.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {


}
