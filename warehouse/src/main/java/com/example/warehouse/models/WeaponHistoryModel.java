package com.example.warehouse.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WeaponHistoryModel {

    private Long id;
    private Long weaponId;
    private Long issuedEmployeeId;
    private Long clientId;
    private Long issuedWarehouseLocationId;
    private LocalDate issueAt;
    private LocalDate returnedAt;
    private String notes;
}
