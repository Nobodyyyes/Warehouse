package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Weapon;
import com.example.warehouse.mappers.WeaponMapper;
import com.example.warehouse.models.WeaponModel;
import com.example.warehouse.repositories.WeaponRepository;
import com.example.warehouse.services.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {

    private final WeaponRepository weaponRepository;

    private final WeaponMapper weaponMapper;

    @Override
    public List<WeaponModel> getAllWeapons() {

        List<WeaponModel> weaponModels = weaponMapper.toModels(weaponRepository.findAll());

        if (weaponModels.isEmpty()) {
            throw new IllegalArgumentException("Weapons does not exists");
        }

        return weaponModels;
    }

    @Override
    public Optional<WeaponModel> getWeaponById(Long id) {

        Optional<Weapon> weapon = weaponRepository.findById(id);

        if (weapon.isPresent()) {
            return weaponMapper.toOptionalModel(weapon);
        }

        return Optional.empty();
    }

    @Override
    public WeaponModel createWeapon(WeaponModel createWeaponModel) {

        Weapon saveWeapon = weaponMapper.toEntity(createWeaponModel);

        return weaponMapper.toModel(weaponRepository.save(saveWeapon));
    }

    @Override
    public WeaponModel updateWeapon(WeaponModel updateWeaponModel) {

        Weapon updatedWeapon = new Weapon()
                .setId(updateWeaponModel.getId())
                .setName(updateWeaponModel.getName())
                .setWeaponType(updateWeaponModel.getWeaponType())
                .setCaliber(updateWeaponModel.getCaliber())
                .setSerialNumber(updateWeaponModel.getSerialNumber())
                .setProductionDate(updateWeaponModel.getProductionDate())
                .setWeaponStatus(updateWeaponModel.getWeaponStatus())
                .setWarehouseLocation(updateWeaponModel.getWarehouseLocation());

        return weaponMapper.toModel(weaponRepository.save(updatedWeapon));
    }

    @Override
    public void deleteWeapon(Long id) {

        Weapon existingWeapon = weaponMapper.toEntity(getWeaponById(id).get());

        if (existingWeapon == null) {
            throw new IllegalArgumentException("Weapon does not exists");
        }

        weaponRepository.deleteById(existingWeapon.getId());
    }
}
