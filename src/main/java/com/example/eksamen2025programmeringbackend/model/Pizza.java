package com.example.eksamen2025programmeringbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pizzaID;
    private String pizzaTitel;
    private int pizzaPris;
    @OneToMany(mappedBy = "pizzaTilLevering")
    @JsonManagedReference("pizza-levering")
    private List<Levering>leveringsList;


    public Pizza(int pizzaID, String pizzaTitel, int pizzaPris, List<Levering> leveringsList) {
        this.pizzaID = pizzaID;
        this.pizzaTitel = pizzaTitel;
        this.pizzaPris = pizzaPris;
        this.leveringsList = leveringsList;
    }

    public Pizza() {
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getPizzaTitel() {
        return pizzaTitel;
    }

    public void setPizzaTitel(String pizzaTitel) {
        this.pizzaTitel = pizzaTitel;
    }

    public int getPizzaPris() {
        return pizzaPris;
    }

    public void setPizzaPris(int pizzaPris) {
        this.pizzaPris = pizzaPris;
    }

    public List<Levering> getLeveringsList() {
        return leveringsList;
    }

    public void setLeveringsList(List<Levering> leveringsList) {
        this.leveringsList = leveringsList;
    }
}
