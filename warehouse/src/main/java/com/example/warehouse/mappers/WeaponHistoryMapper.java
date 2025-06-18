package com.example.warehouse.mappers;

import com.example.warehouse.entities.WeaponHistory;
import com.example.warehouse.models.WeaponHistoryModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class WeaponHistoryMapper {

    public WeaponHistory toEntity(WeaponHistoryModel model) {
        return new WeaponHistory()
                .setId(model.getId())
                .setWeaponId(model.getWeaponId())
                .setIssuedEmployeeId(model.getIssuedEmployeeId())
                .setClientId(model.getClientId())
                .setIssuedWarehouseLocationId(model.getIssuedWarehouseLocationId())
                .setIssueAt(model.getIssueAt())
                .setReturnedAt(model.getReturnedAt())
                .setNotes(model.getNotes());
    }

    public WeaponHistoryModel toModel(WeaponHistory entity) {
        return new WeaponHistoryModel()
                .setId(entity.getId())
                .setWeaponId(entity.getWeaponId())
                .setIssuedEmployeeId(entity.getIssuedEmployeeId())
                .setClientId(entity.getClientId())
                .setIssuedWarehouseLocationId(entity.getIssuedWarehouseLocationId())
                .setIssueAt(entity.getIssueAt())
                .setReturnedAt(entity.getReturnedAt())
                .setNotes(entity.getNotes());
    }

    public List<WeaponHistory> toEntities(List<WeaponHistoryModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<WeaponHistoryModel> toModels(List<WeaponHistory> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Optional<WeaponHistoryModel> toOptionalModel(Optional<WeaponHistory> optionalEntity) {
        return optionalEntity.map(this::toModel);
    }
}
