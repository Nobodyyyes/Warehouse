package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Weapon;
import com.example.warehouse.mappers.BaseMapper;
import com.example.warehouse.models.WeaponModel;
import com.example.warehouse.services.WeaponService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class WeaponServiceImpl extends BaseServiceImpl<WeaponModel, Weapon, Long> implements WeaponService {

    public WeaponServiceImpl(JpaRepository<Weapon, Long> repository, BaseMapper<WeaponModel, Weapon> baseMapper) {
        super(repository, baseMapper);
    }
}
