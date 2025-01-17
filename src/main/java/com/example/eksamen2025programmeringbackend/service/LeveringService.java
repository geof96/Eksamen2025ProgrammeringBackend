package com.example.eksamen2025programmeringbackend.service;

import com.example.eksamen2025programmeringbackend.model.Drone;
import com.example.eksamen2025programmeringbackend.model.Levering;
import com.example.eksamen2025programmeringbackend.model.enums.DroneStatus;
import com.example.eksamen2025programmeringbackend.repository.DroneRepository;
import com.example.eksamen2025programmeringbackend.repository.LeveringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class LeveringService {

    @Autowired
    LeveringRepository leveringRepository;

    @Autowired
    DroneRepository droneRepository;


    public List<Levering> seAlleLeveringerSomIkkeErLeveret() {

        return leveringRepository.findAll().stream()
                .filter(levering -> !levering.isFaktiskLevering())
                .sorted(Comparator.comparing(Levering::getForventetLevering))
                .toList();
    }

    public List<Levering> seAlleLeveringerUdenDroner() {
        return leveringRepository.findAll().stream()
                .filter(levering -> levering.getLeveringsDrone() == null)
                .sorted(Comparator.comparing(Levering::getForventetLevering))
                .toList();
    }

    public Levering opretNyeLeveringer(Levering nyLevering) {
        nyLevering.setForventetLevering(LocalTime.now().plusMinutes(30));
        nyLevering.setFaktiskLevering(false);
        return leveringRepository.save(nyLevering);
    }

    public ResponseEntity<Levering> leveringTilDrone(int leveringID) {
        Optional<Levering> levering = leveringRepository.findById(leveringID);

        if (levering.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Levering denOpdateretLevering = levering.get();

        if (denOpdateretLevering.getLeveringsDrone() != null) {
            throw new IllegalStateException("Denne levering har allerede en drone");
        }

        // Find en tilfældig drone i drift
        Drone dronerTilstede = droneRepository.findAll().stream()
                .filter(drone -> drone.getDroneStatus() == DroneStatus.I_DRIFT)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Alle droner er i drift"));

        denOpdateretLevering.setLeveringsDrone(dronerTilstede);

        leveringRepository.save(denOpdateretLevering);
        return ResponseEntity.ok(denOpdateretLevering);
    }



}
