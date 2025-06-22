package com.example.warehouse.enums.employee;

import lombok.Getter;

@Getter
public enum EmployeeRank {

    GUARD("Охранник"),
    JUNIOR_SERGEANT("Младший сержант"),
    SERGEANT("Сержант"),
    SENIOR_SERGEANT("Старший сержант"),
    LIEUTENANT("Лейтенант"),
    CAPTAIN("Капитан");

    private final String description;

    EmployeeRank(String description) {
        this.description = description;
    }
}
