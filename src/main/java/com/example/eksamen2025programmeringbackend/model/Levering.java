package com.example.eksamen2025programmeringbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Levering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leveringsID;
    private String adresse;
    @Column(nullable = false)
    private LocalTime forventetLevering;
    private LocalTime faktiskLevering;
    @ManyToOne
    @JoinColumn(name = "pizzaFK", referencedColumnName = "pizzaID")
    @JsonBackReference("pizza-levering")
    private Pizza pizzaTilLevering;

    @ManyToOne
    @JoinColumn(name = "droneFK", referencedColumnName = "droneID")
    @JsonBackReference("drone-lervering")
    private Drone leveringsDrone;

    public Levering(String adresse, LocalTime forventetLevering, LocalTime faktiskLevering, Pizza pizzaTilLevering) {
        if (forventetLevering == null) {
            throw new IllegalArgumentException("Du skal indtaste den forventede leveringstid");
        }
        this.adresse = adresse;
        this.forventetLevering = forventetLevering;
        this.faktiskLevering = faktiskLevering;
        this.pizzaTilLevering = pizzaTilLevering;
    }

    public Levering() {
    }

    public int getLeveringsID() {
        return leveringsID;
    }

    public void setLeveringsID(int leveringsID) {
        this.leveringsID = leveringsID;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalTime getForventetLevering() {
        return forventetLevering;
    }

    public void setForventetLevering(LocalTime forventetLevering) {
        this.forventetLevering = forventetLevering;
    }

    public LocalTime getFaktiskLevering() {
        return faktiskLevering;
    }

    public void setFaktiskLevering(LocalTime faktiskLevering) {
        this.faktiskLevering = faktiskLevering;
    }

    public Pizza getPizzaTilLevering() {
        return pizzaTilLevering;
    }

    public void setPizzaTilLevering(Pizza pizzaTilLevering) {
        this.pizzaTilLevering = pizzaTilLevering;
    }

    public Drone getLeveringsDrone() {
        return leveringsDrone;
    }

    public void setLeveringsDrone(Drone leveringsDrone) {
        this.leveringsDrone = leveringsDrone;
    }
}
