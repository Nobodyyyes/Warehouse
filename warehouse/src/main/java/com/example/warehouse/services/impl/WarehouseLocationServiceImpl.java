package com.example.warehouse.services.impl;

import com.example.warehouse.entities.WarehouseLocation;
import com.example.warehouse.mappers.BaseMapper;
import com.example.warehouse.models.WarehouseLocationModel;
import com.example.warehouse.services.WarehouseLocationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class WarehouseLocationServiceImpl extends BaseServiceImpl<WarehouseLocationModel, WarehouseLocation, Long> implements WarehouseLocationService {

    public WarehouseLocationServiceImpl(JpaRepository<WarehouseLocation, Long> repository, BaseMapper<WarehouseLocationModel, WarehouseLocation> baseMapper) {
        super(repository, baseMapper);
    }
}
