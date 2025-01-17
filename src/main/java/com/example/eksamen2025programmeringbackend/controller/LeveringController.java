package com.example.eksamen2025programmeringbackend.controller;

import com.example.eksamen2025programmeringbackend.model.Levering;
import com.example.eksamen2025programmeringbackend.service.LeveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LeveringController {

    @Autowired
    LeveringService leveringService;

    @GetMapping("/deliveries")
    public List<Levering> seAlleLeveringerSomIkkeErLeveret() {
        return leveringService.seAlleLeveringerSomIkkeErLeveret();
    }

    @PostMapping("/deliveries/add")
    public ResponseEntity<Levering> opretLevering(@RequestBody Levering nyLevering) {
        Levering levering = leveringService.opretNyeLeveringer(nyLevering);
        return new ResponseEntity<>(levering, HttpStatus.CREATED);
    }

    @GetMapping("deliveries/queue")
    public List<Levering> leveringerUdenDrone() {
        return leveringService.seAlleLeveringerUdenDroner();
    }

    @PutMapping("deliveries/schedule/{leveringID}")
    public ResponseEntity<Levering> leveringTilDrone(@PathVariable int leveringID, @RequestParam Integer droneID) {
        return leveringService.leveringTilDrone(leveringID, droneID);

    }


}
