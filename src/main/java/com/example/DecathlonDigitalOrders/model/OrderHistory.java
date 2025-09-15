package com.example.DecathlonDigitalOrders.model;


import jakarta.persistence.*;
        import java.time.LocalDate;

@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long teammateId;
    private String teammateName;

    private int dailyOrders;
    private int monthlyOrders;
    private LocalDate date;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTeammateId() { return teammateId; }
    public void setTeammateId(Long teammateId) { this.teammateId = teammateId; }

    public String getTeammateName() { return teammateName; }
    public void setTeammateName(String teammateName) { this.teammateName = teammateName; }

    public int getDailyOrders() { return dailyOrders; }
    public void setDailyOrders(int dailyOrders) { this.dailyOrders = dailyOrders; }

    public int getMonthlyOrders() { return monthlyOrders; }
    public void setMonthlyOrders(int monthlyOrders) { this.monthlyOrders = monthlyOrders; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
