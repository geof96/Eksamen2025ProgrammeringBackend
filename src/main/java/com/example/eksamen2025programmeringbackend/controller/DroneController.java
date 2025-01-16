package com.example.eksamen2025programmeringbackend.controller;

import com.example.eksamen2025programmeringbackend.model.Drone;
import com.example.eksamen2025programmeringbackend.model.enums.DroneStatus;
import com.example.eksamen2025programmeringbackend.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/add")
    public ResponseEntity<Drone> opretDrone(@RequestBody Drone inputDrone) {
        System.out.println("hej");
        if (droneService.gemDrone(inputDrone) != null) {
            return new ResponseEntity<>(inputDrone, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(inputDrone, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("drones")
    public List<Drone> visAlleDroner() {
        return droneService.seAlleDroner();
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<Drone> sætIDrift(@PathVariable int id) {
        return droneService.opdaterDroneInfo(DroneStatus.I_DRIFT, id);
    }

    @PutMapping("/disable/{id}")
    public ResponseEntity<Drone> afslutDrift(@PathVariable int id) {
        return droneService.opdaterDroneInfo(DroneStatus.UDE_AF_DRIFT, id);
    }


    @PutMapping("/retire/{id}")
    public ResponseEntity<Drone> udfaseDrone(@PathVariable int id) {
        System.out.println("Her er: " + id);
        return droneService.opdaterDroneInfo(DroneStatus.UDFASET, id);
    }
}
