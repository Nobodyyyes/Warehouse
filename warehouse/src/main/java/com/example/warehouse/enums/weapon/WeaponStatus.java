package com.example.warehouse.enums.weapon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeaponStatus {

    IN_STOCK("В наличии"),
    ISSUED("Выпущенные"),
    UNDER_MAINTENANCE("В обслуживании"),
    DECOMMISSIONED("Снятые с экплуатации");

    private final String status;
}
