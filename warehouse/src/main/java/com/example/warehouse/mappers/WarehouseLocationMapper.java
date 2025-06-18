package com.example.warehouse.mappers;

import com.example.warehouse.entities.WarehouseLocation;
import com.example.warehouse.models.WarehouseLocationModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WarehouseLocationMapper {

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
                .setDescription(entity.getDescription());
    }

    public List<WarehouseLocation> toEntities(List<WarehouseLocationModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<WarehouseLocationModel> toModels(List<WarehouseLocation> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
