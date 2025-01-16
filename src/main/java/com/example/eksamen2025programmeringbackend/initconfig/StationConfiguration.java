package com.example.eksamen2025programmeringbackend.initconfig;

import com.example.eksamen2025programmeringbackend.model.Station;
import com.example.eksamen2025programmeringbackend.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StationConfiguration implements CommandLineRunner {

    @Autowired
    StationRepository stationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (stationRepository.count() == 0 || stationRepository.count() <= 3) {

            //Her laver vi 3 nye Stations objekter, da de skal hardcodes.
            Station station1 = new Station();
            station1.setLængdeGrad(12.5683f);
            station1.setBreddeGrad(55.6761f);
            stationRepository.save(station1);

            Station station2 = new Station();
            station2.setLængdeGrad(12.5403f);
            station2.setBreddeGrad(55.6850f);
            stationRepository.save(station2);

            Station station3 = new Station();
            station3.setLængdeGrad(12.5519f);
            station3.setBreddeGrad(55.6928f);
            stationRepository.save(station3);

            System.out.println("Stationer er blevet tilføjet til databasen!!");
        }
    }
}
