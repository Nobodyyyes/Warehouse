package com.example.warehouse.mappers;

import com.example.warehouse.entities.Weapon;
import com.example.warehouse.models.WeaponModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeaponMapper implements BaseMapper<WeaponModel, Weapon> {

    private final WeaponHistoryMapper weaponHistoryMapper;

    public Weapon toEntity(WeaponModel model) {
        return new Weapon()
                .setId(model.getId())
                .setName(model.getName())
                .setWeaponType(model.getWeaponType())
                .setCaliber(model.getCaliber())
                .setSerialNumber(model.getSerialNumber())
                .setProductionDate(model.getProductionDate())
                .setWeaponStatus(model.getWeaponStatus());
    }

    public WeaponModel toModel(Weapon entity) {
        return new WeaponModel()
                .setId(entity.getId())
                .setName(entity.getName())
                .setWeaponType(entity.getWeaponType())
                .setCaliber(entity.getCaliber())
                .setSerialNumber(entity.getSerialNumber())
                .setProductionDate(entity.getProductionDate())
                .setWeaponStatus(entity.getWeaponStatus())
                .setWeaponHistories(weaponHistoryMapper.toModels(entity.getWeaponHistories()));
    }
}
