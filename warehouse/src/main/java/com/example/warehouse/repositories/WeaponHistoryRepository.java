package com.example.warehouse.repositories;

import com.example.warehouse.entities.WeaponHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeaponHistoryRepository extends JpaRepository<WeaponHistory, Long> {

    List<WeaponHistory> findByIssueAtBetween(LocalDate from, LocalDate to);
}
