package com.example.warehouse.mappers;

import com.example.warehouse.entities.Weapon;
import com.example.warehouse.models.WeaponModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class WeaponMapper {

    public Weapon toEntity(WeaponModel model) {
        return new Weapon()
                .setId(model.getId())
                .setName(model.getName())
                .setWeaponType(model.getWeaponType())
                .setCaliber(model.getCaliber())
                .setSerialNumber(model.getSerialNumber())
                .setProductionDate(model.getProductionDate())
                .setWeaponStatus(model.getWeaponStatus())
                .setIssuedEmployeeId(model.getIssuedEmployeeId())
                .setClientId(model.getClientId());
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
                .setIssuedEmployeeId(entity.getIssuedEmployeeId())
                .setClientId(entity.getClientId());
    }

    public List<Weapon> toEntities(List<WeaponModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<WeaponModel> toModels(List<Weapon> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Optional<WeaponModel> toOptionalModel(Optional<Weapon> optionalEntity) {
        return optionalEntity.map(this::toModel);
    }
}
