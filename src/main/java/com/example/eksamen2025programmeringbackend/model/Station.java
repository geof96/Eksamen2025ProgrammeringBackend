package com.example.eksamen2025programmeringbackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationID;
    private float længdeGrad;
    private float breddeGrad;

    @OneToMany
    private List<Drone> dronerIStation;

    public Station() {
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public float getLængdeGrad() {
        return længdeGrad;
    }

    public void setLængdeGrad(float længdeGrad) {
        this.længdeGrad = længdeGrad;
    }

    public float getBreddeGrad() {
        return breddeGrad;
    }

    public void setBreddeGrad(float breddeGrad) {
        this.breddeGrad = breddeGrad;
    }

    public List<Drone> getDronerIStation() {
        return dronerIStation;
    }

    public void setDronerIStation(List<Drone> dronerIStation) {
        this.dronerIStation = dronerIStation;
    }
}
