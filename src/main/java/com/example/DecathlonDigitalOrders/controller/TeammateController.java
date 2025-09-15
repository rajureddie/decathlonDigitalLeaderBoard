package com.example.DecathlonDigitalOrders.controller;

import com.example.DecathlonDigitalOrders.model.Teammate;
import com.example.DecathlonDigitalOrders.repository.TeammateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teammates")
@CrossOrigin(origins = "http://127.0.0.1:5500") // allow your frontend
public class TeammateController {

    private final TeammateRepository teammateRepository;

    public TeammateController(TeammateRepository teammateRepository) {
        this.teammateRepository = teammateRepository;
    }

    @GetMapping
    public List<Teammate> getAll() {
        return teammateRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teammate> getById(@PathVariable Long id) {
        return teammateRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ UPDATE daily & monthly orders only
    @PutMapping("/{id}")
    public ResponseEntity<Teammate> updateTeammate(
            @PathVariable Long id,
            @RequestBody Teammate updateData) {
        return teammateRepository.findById(id)
                .map(teammate -> {
                    teammate.setDailyOrders(updateData.getDailyOrders());
                    teammate.setMonthlyOrders(updateData.getMonthlyOrders());
                    Teammate updated = teammateRepository.save(teammate);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
