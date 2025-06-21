package com.example.warehouse.models;

import com.example.warehouse.entities.Client;
import com.example.warehouse.entities.WarehouseLocation;
import com.example.warehouse.enums.WeaponStatus;
import com.example.warehouse.enums.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WeaponModel {

    private Long id;
    private String name;
    private WeaponType weaponType;
    private String caliber;
    private String serialNumber;
    private LocalDate productionDate;
    private WeaponStatus weaponStatus;
    private WarehouseLocation warehouseLocation;
    private Client client;
    private List<WeaponHistoryModel> weaponHistories;
}
