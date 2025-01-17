package com.example.eksamen2025programmeringbackend.service;

import com.example.eksamen2025programmeringbackend.model.Levering;
import com.example.eksamen2025programmeringbackend.repository.LeveringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

@Service
public class LeveringService {

    @Autowired
    LeveringRepository leveringRepository;


    public List<Levering> seAlleLeveringerSomIkkeErLeveret() {

        return leveringRepository.findAll().stream()
                .filter(levering -> !levering.isFaktiskLevering())
                .sorted(Comparator.comparing(Levering::getForventetLevering))
                .toList()

                ;
    }

    public Levering opretNyeLeveringer(Levering nyLevering) {
        nyLevering.setForventetLevering(LocalTime.now().plusMinutes(30));
        nyLevering.setFaktiskLevering(false);
        return leveringRepository.save(nyLevering);
    }

}
