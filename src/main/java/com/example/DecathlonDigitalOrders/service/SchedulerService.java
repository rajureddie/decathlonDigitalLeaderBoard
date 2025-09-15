package com.example.DecathlonDigitalOrders.service;


import com.example.DecathlonDigitalOrders.model.OrderHistory;
import com.example.DecathlonDigitalOrders.model.Teammate;
import com.example.DecathlonDigitalOrders.repository.OrderHistoryRepository;
import com.example.DecathlonDigitalOrders.repository.TeammateRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulerService {
    private final TeammateRepository repository;
    private final OrderHistoryRepository historyRepository;

    public SchedulerService(TeammateRepository repository, OrderHistoryRepository historyRepository) {
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    // ✅ Save history + reset daily orders every midnight
    @Scheduled(cron = "0 0 0 * * ?")
    public void resetDailyOrders() {
        List<Teammate> teammates = repository.findAll();

        for (Teammate t : teammates) {
            OrderHistory history = new OrderHistory();
            history.setTeammateId(t.getId());
            history.setTeammateName(t.getName());
            history.setDailyOrders(t.getDailyOrders());
            history.setMonthlyOrders(t.getMonthlyOrders());
            history.setDate(LocalDate.now());
            historyRepository.save(history);

            t.setDailyOrders(0);
        }
        repository.saveAll(teammates);
        System.out.println("✅ Daily orders reset & history saved");
    }

    // ✅ Reset monthly orders on 1st day of month
    @Scheduled(cron = "0 0 0 1 * ?")
    public void resetMonthlyOrders() {
        List<Teammate> teammates = repository.findAll();
        for (Teammate t : teammates) {
            t.setMonthlyOrders(0);
        }
        repository.saveAll(teammates);
        System.out.println("✅ Monthly orders reset");
    }
}
