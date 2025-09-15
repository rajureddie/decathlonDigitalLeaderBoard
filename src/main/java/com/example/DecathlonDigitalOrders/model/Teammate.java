package com.example.DecathlonDigitalOrders.model;


import jakarta.persistence.*;

@Entity
public class Teammate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int dailyOrders;     // orders placed today
    private int monthlyOrders;   // total orders this month

    private String photoUrl;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDailyOrders() { return dailyOrders; }
    public void setDailyOrders(int dailyOrders) { this.dailyOrders = dailyOrders; }

    public int getMonthlyOrders() { return monthlyOrders; }
    public void setMonthlyOrders(int monthlyOrders) { this.monthlyOrders = monthlyOrders; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}
