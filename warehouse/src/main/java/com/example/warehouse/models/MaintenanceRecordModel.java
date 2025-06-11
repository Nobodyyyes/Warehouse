package com.example.warehouse.models;

import com.example.warehouse.entities.Weapon;
import com.example.warehouse.enums.MaintenanceStatus;
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
public class MaintenanceRecordModel {

    private Long id;
    private Weapon weapon;
    private LocalDate performedAt;
    private String performedBy;
    private String description;
    private MaintenanceStatus maintenanceStatus;
}
