package com.example.warehouse.enums.employee;

import lombok.Getter;

@Getter
public enum EmployeePosition {

    WAREHOUSE_MANAGER("Заведующий складом"),
    ARMORER("Оружейник"),
    SECURITY_OFFICER("Сотрудник охраны"),
    LOGISTICS_OFFICER("Ответственный за логистику"),
    INSPECTOR("Инспектор"),
    DEPUTY_MANAGER("Заместитель заведующего");

    private final String description;

    EmployeePosition(String description) {
        this.description = description;
    }
}
