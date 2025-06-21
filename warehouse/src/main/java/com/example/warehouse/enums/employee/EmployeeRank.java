package com.example.warehouse.enums.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmployeeRank {

    GUARD("Охранник"),
    JUNIOR_SERGEANT("Младший сержант"),
    SERGEANT("Сержант"),
    SENIOR_SERGEANT("Старший сержант"),
    LIEUTENANT("Лейтенант"),
    CAPTAIN("Капитан");

    private final String description;
}
