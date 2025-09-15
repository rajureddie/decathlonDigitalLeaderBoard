package com.example.DecathlonDigitalOrders.controller;




import com.example.DecathlonDigitalOrders.model.OrderHistory;
import com.example.DecathlonDigitalOrders.repository.OrderHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class OrderHistoryController {
    private final OrderHistoryRepository historyRepository;

    public OrderHistoryController(OrderHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @GetMapping
    public List<OrderHistory> getAllHistory() {
        return historyRepository.findAll();
    }

    @GetMapping("/teammate/{id}")
    public List<OrderHistory> getHistoryByTeammate(@PathVariable Long id) {
        return historyRepository.findByTeammateId(id);
    }

    @GetMapping("/date/{date}")
    public List<OrderHistory> getHistoryByDate(@PathVariable String date) {
        return historyRepository.findByDate(LocalDate.parse(date));
    }
}
