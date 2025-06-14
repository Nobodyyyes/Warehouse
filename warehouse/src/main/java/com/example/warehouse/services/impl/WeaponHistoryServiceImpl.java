package com.example.warehouse.services.impl;

import com.example.warehouse.entities.WeaponHistory;
import com.example.warehouse.mappers.WeaponHistoryMapper;
import com.example.warehouse.models.WeaponHistoryModel;
import com.example.warehouse.repositories.WeaponHistoryRepository;
import com.example.warehouse.services.WeaponHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponHistoryServiceImpl implements WeaponHistoryService {

    private final WeaponHistoryRepository weaponHistoryRepository;

    private final WeaponHistoryMapper weaponHistoryMapper;

    @Override
    public List<WeaponHistoryModel> getAllHistory() {

        List<WeaponHistoryModel> weaponHistoryModels = weaponHistoryMapper.toModels(weaponHistoryRepository.findAll());

        if (weaponHistoryModels.isEmpty()) {
            throw new IllegalArgumentException("Weapon histories does not exists");
        }

        return weaponHistoryModels;
    }

    @Override
    public List<WeaponHistoryModel> getHistoryFromTo(LocalDate from, LocalDate to) {

        List<WeaponHistoryModel> weaponHistoryModelsBetween = weaponHistoryMapper.toModels(weaponHistoryRepository.findByIssueAtBetween(from, to));

        if (weaponHistoryModelsBetween.isEmpty()) {
            throw new IllegalArgumentException("From date %s to %s history is empty".formatted(from, to));
        }

        return weaponHistoryModelsBetween;
    }

    @Override
    public Optional<WeaponHistoryModel> getHistory(Long id) {

        return weaponHistoryMapper.toOptionalModel(weaponHistoryRepository.findById(id));
    }

    @Override
    public WeaponHistoryModel createWeaponHistory(WeaponHistoryModel model) {

        WeaponHistory createWeaponHistory = new WeaponHistory()
                .setId(model.getId())
                .setWeapon(model.getWeapon())
                .setEmployee(model.getEmployee())
                .setIssueAt(model.getIssueAt())
                .setReturnedAt(model.getReturnedAt())
                .setIssuedBy(model.getIssuedBy())
                .setNotes(model.getNotes());

        return weaponHistoryMapper.toModel(weaponHistoryRepository.save(createWeaponHistory));
    }

    @Override
    public void deleteHistory(Long id) {

        WeaponHistory existingWeaponHistory = weaponHistoryMapper.toEntity(getHistory(id).get());

        if (existingWeaponHistory == null) {
            throw new IllegalArgumentException("Weapon history does no exists");
        }

        weaponHistoryRepository.deleteById(existingWeaponHistory.getId());
    }
}
