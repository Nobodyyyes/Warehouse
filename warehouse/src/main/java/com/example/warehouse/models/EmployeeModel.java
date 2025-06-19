package com.example.warehouse.models;

import com.example.warehouse.enums.EmployeePosition;
import com.example.warehouse.enums.EmployeeRank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeModel {

    private Long id;
    private String fullName;
    private EmployeeRank rank;
    private EmployeePosition position;
    private String department;
    private String passportNumber;
    private String serviceNumber;
    private Boolean isActive;
    private List<WeaponModel> weapons;
}
