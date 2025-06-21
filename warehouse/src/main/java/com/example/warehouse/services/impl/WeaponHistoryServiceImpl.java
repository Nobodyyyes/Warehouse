package com.example.warehouse.services.impl;

import com.example.warehouse.entities.WeaponHistory;
import com.example.warehouse.mappers.BaseMapper;
import com.example.warehouse.models.WeaponHistoryModel;
import com.example.warehouse.services.WeaponHistoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class WeaponHistoryServiceImpl extends BaseServiceImpl<WeaponHistoryModel, WeaponHistory, Long> implements WeaponHistoryService {

    public WeaponHistoryServiceImpl(JpaRepository<WeaponHistory, Long> repository, BaseMapper<WeaponHistoryModel, WeaponHistory> baseMapper) {
        super(repository, baseMapper);
    }
}
