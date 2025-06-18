package com.example.warehouse.services;

import com.example.warehouse.models.WarehouseLocationModel;

import java.util.List;
import java.util.Optional;

public interface WarehouseLocationService {

    List<WarehouseLocationModel> getAllLocations();

    Optional<WarehouseLocationModel> getLocation(Long id);

    WarehouseLocationModel createLocation(WarehouseLocationModel newLocation);

    WarehouseLocationModel updateLocation(WarehouseLocationModel updatableLocation);

    void deleteLocation(Long id);
}
