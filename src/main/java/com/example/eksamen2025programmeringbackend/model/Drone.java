package com.example.eksamen2025programmeringbackend.model;

import com.example.eksamen2025programmeringbackend.model.enums.DroneStatus;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int droneID;
    private int serieNummer;
    @Enumerated(EnumType.STRING)
    private DroneStatus droneStatus;

    @OneToMany
    private List<Levering>leveringerTilDrone;

    @ManyToOne
            @JoinColumn(name = "stationFK", referencedColumnName = "stationID")
    private Station specifikkeDronesStation;

    public Drone(int droneID, int serieNummer, DroneStatus droneStatus, List<Levering> leveringerTilDrone, Station specifikkeDronesStation) {
        this.droneID = droneID;
        this.serieNummer = serieNummer;
        this.droneStatus = droneStatus;
        this.leveringerTilDrone = leveringerTilDrone;
        this.specifikkeDronesStation = specifikkeDronesStation;
    }

    public Drone() {
    }

    public int getDroneID() {
        return droneID;
    }

    public void setDroneID(int droneID) {
        this.droneID = droneID;
    }

    public int getSerieNummer() {
        return serieNummer;
    }

    public void setSerieNummer(int serieNummer) {
        this.serieNummer = serieNummer;
    }

    public DroneStatus getDroneStatus() {
        return droneStatus;
    }

    public void setDroneStatus(DroneStatus droneStatus) {
        this.droneStatus = droneStatus;
    }

    public List<Levering> getLeveringerTilDrone() {
        return leveringerTilDrone;
    }

    public void setLeveringerTilDrone(List<Levering> leveringerTilDrone) {
        this.leveringerTilDrone = leveringerTilDrone;
    }

    public Station getSpecifikkeDronesStation() {
        return specifikkeDronesStation;
    }

    public void setSpecifikkeDronesStation(Station specifikkeDronesStation) {
        this.specifikkeDronesStation = specifikkeDronesStation;
    }
}
