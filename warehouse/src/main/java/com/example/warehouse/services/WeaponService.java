package com.example.warehouse.services;

import com.example.warehouse.models.WeaponModel;

import java.util.List;
import java.util.Optional;

public interface WeaponService {

    List<WeaponModel> getAllWeapons();

    Optional<WeaponModel> getWeaponById(Long id);

    WeaponModel createWeapon(WeaponModel createWeaponModel);

    WeaponModel updateWeapon(WeaponModel updateWeaponModel);

    void deleteWeapon(Long id);
}
