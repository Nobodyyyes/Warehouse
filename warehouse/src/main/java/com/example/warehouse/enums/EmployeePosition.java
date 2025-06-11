package com.example.warehouse.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmployeePosition {

    WAREHOUSE_MANAGER("Заведующий складом"),
    ARMORER("Оружейник"),
    SECURITY_OFFICER("Сотрудник охраны"),
    LOGISTICS_OFFICER("Ответственный за логистику"),
    INSPECTOR("Инспектор"),
    DEPUTY_MANAGER("Заместитель заведующего");

    private final String description;
}
