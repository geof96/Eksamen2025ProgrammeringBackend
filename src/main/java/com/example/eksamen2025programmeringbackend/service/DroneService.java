package com.example.eksamen2025programmeringbackend.service;

import com.example.eksamen2025programmeringbackend.model.Drone;
import com.example.eksamen2025programmeringbackend.model.Station;
import com.example.eksamen2025programmeringbackend.model.enums.DroneStatus;
import com.example.eksamen2025programmeringbackend.repository.DroneRepository;
import com.example.eksamen2025programmeringbackend.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;


@Service
public class DroneService {

    @Autowired
    DroneRepository droneRepository;
    @Autowired
    StationRepository stationRepository;

    //Businesslogic for at vise alle droner.
    public List<Drone> seAlleDroner() {

        return droneRepository.findAll();
    }


    public Drone gemDrone(Drone drone) {
        List<Station> stations = stationRepository.findAll();
        if (!stations.isEmpty()) {
            //Her bruger vi en comparator til at sammenligne de forskellige stationers drone antal
            Station dronensStation = stations.stream()
                    .min((station1, station2) -> Integer.compare(
                            station1.getDronerIStation().size(),
                            station2.getDronerIStation().size()
                    ))
                    .orElseThrow(() -> new IllegalStateException("Kan finde en station til denne drone"));

            //Her sætter vi dronens station og drift-status
            drone.setSpecifikkeDronesStation(dronensStation);
            drone.setDroneStatus(DroneStatus.I_DRIFT);
            drone.setSerieNummer(Random.from(RandomGenerator.getDefault()).nextInt(200000, 400000));

            //Her gemmes den ny drone
            Drone newDrone = droneRepository.save(drone);

            //Her gemmer vi dronen under den specifikke stations liste
            dronensStation.getDronerIStation().add(drone);

            //Her gemmer vi stationen i databasen via JPA.
            stationRepository.save(dronensStation);

            //Her gemmer vi dronen i databasen.
            return newDrone;
        } else {
            new IllegalStateException("Der ingen stationer tilængelig for denne drone");
        }
        return drone;
    }

    public ResponseEntity<Drone> opdaterDroneInfo(DroneStatus nyDroneStatus, int id) {
        return droneRepository.findById(id).map(eksisterendeDrone -> {
            if (eksisterendeDrone.getDroneStatus() == DroneStatus.UDFASET) {
                throw new IllegalStateException("Dronen med denne ID: " + id + " er udfaset");
            }
            eksisterendeDrone.setDroneStatus(nyDroneStatus);
            Drone opdateretDrone = droneRepository.save(eksisterendeDrone);
            return ResponseEntity.ok(opdateretDrone);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


}

