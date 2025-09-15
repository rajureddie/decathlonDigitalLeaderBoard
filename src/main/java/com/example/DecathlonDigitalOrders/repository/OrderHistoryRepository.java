package com.example.DecathlonDigitalOrders.repository;

import com.example.DecathlonDigitalOrders.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    List<OrderHistory> findByTeammateId(Long teammateId);
    List<OrderHistory> findByDate(LocalDate date);
}
