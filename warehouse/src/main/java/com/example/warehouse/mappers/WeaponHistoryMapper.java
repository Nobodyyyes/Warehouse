package com.example.warehouse.mappers;

import com.example.warehouse.entities.WeaponHistory;
import com.example.warehouse.models.WeaponHistoryModel;
import org.springframework.stereotype.Component;

@Component
public class WeaponHistoryMapper implements BaseMapper<WeaponHistoryModel, WeaponHistory> {

    public WeaponHistory toEntity(WeaponHistoryModel model) {
        return new WeaponHistory()
                .setId(model.getId())
                .setIssuedBy(model.getIssuedBy())
                .setIssuedTo(model.getIssuedTo())
                .setIssuedFrom(model.getIssuedFrom())
                .setIssueAt(model.getIssueAt())
                .setReturnedAt(model.getReturnedAt())
                .setNotes(model.getNotes());
    }

    public WeaponHistoryModel toModel(WeaponHistory entity) {
        return new WeaponHistoryModel()
                .setId(entity.getId())
                .setIssuedBy(entity.getIssuedBy())
                .setIssuedTo(entity.getIssuedTo())
                .setIssuedFrom(entity.getIssuedFrom())
                .setIssueAt(entity.getIssueAt())
                .setReturnedAt(entity.getReturnedAt())
                .setNotes(entity.getNotes())
                .setWeapon(entity.getWeapon());
    }
}
