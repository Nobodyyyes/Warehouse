package com.example.warehouse.models;

import com.example.warehouse.entities.WeaponHistory;
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
    private Long issuedEmployeeId;
    private Long clientId;
    private List<WeaponHistoryModel> weaponHistories;
}
