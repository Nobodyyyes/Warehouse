package com.example.warehouse.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaintenanceStatus {

    READY("Готов"),
    FAULTY("Неисправный"),
    SCRAPPED("Списанный");

    private final String description;
}
