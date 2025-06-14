package com.example.warehouse.services;

import com.example.warehouse.models.WeaponHistoryModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeaponHistoryService {

    List<WeaponHistoryModel> getAllHistory();

    List<WeaponHistoryModel> getHistoryFromTo(LocalDate from, LocalDate to);

    Optional<WeaponHistoryModel> getHistory(Long id);

    WeaponHistoryModel createWeaponHistory(WeaponHistoryModel model);

    void deleteHistory(Long id);
}
