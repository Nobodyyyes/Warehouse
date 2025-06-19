package com.example.warehouse.mappers;

import com.example.warehouse.entities.WarehouseLocation;
import com.example.warehouse.models.WarehouseLocationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseLocationMapper implements BaseMapper<WarehouseLocationModel, WarehouseLocation> {

    private final WeaponMapper weaponMapper;

    public WarehouseLocation toEntity(WarehouseLocationModel model) {
        return new WarehouseLocation()
                .setId(model.getId())
                .setSection(model.getSection())
                .setShelf(model.getShelf())
                .setDescription(model.getDescription());
    }

    public WarehouseLocationModel toModel(WarehouseLocation entity) {
        return new WarehouseLocationModel()
                .setId(entity.getId())
                .setSection(entity.getSection())
                .setShelf(entity.getShelf())
                .setDescription(entity.getDescription())
                .setWeapons(weaponMapper.toModels(entity.getWeapons()));
    }
}
