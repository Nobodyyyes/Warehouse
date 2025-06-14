package com.example.warehouse.repositories;

import com.example.warehouse.entities.WarehouseLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseLocationRepository extends JpaRepository<WarehouseLocation, Long> {

}
