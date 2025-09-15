package com.example.DecathlonDigitalOrders.service;

import com.example.DecathlonDigitalOrders.model.Teammate;
import com.example.DecathlonDigitalOrders.repository.TeammateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeammateService {
    private final TeammateRepository repository;

    public TeammateService(TeammateRepository repository) {
        this.repository = repository;
    }

    public List<Teammate> getAll() {
        return repository.findAll();
    }

    public Teammate addTeammate(Teammate teammate) {
        return repository.save(teammate);
    }

    public Teammate updateTeammate(Long id, Teammate newData) {
        return repository.findById(id).map(t -> {
            t.setName(newData.getName());
            t.setDailyOrders(newData.getDailyOrders());
            t.setMonthlyOrders(newData.getMonthlyOrders());
            t.setPhotoUrl(newData.getPhotoUrl());
            return repository.save(t);
        }).orElseThrow(() -> new RuntimeException("Teammate not found"));
    }
}
