package com.example.warehouse.models;

import com.example.warehouse.entities.Client;
import com.example.warehouse.entities.Employee;
import com.example.warehouse.entities.WarehouseLocation;
import com.example.warehouse.entities.Weapon;
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
    private Employee issuedBy;
    private Client issuedTo;
    private WarehouseLocation issuedFrom;
    private LocalDate issueAt;
    private LocalDate returnedAt;
    private String notes;
    private Weapon weapon;
}
