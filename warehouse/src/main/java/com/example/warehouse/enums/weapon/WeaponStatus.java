package com.example.warehouse.enums.weapon;

import lombok.Getter;

@Getter
public enum WeaponStatus {

    IN_STOCK("В наличии"),
    ISSUED("Выпущенные"),
    UNDER_MAINTENANCE("В обслуживании"),
    DECOMMISSIONED("Снятые с экcплуатации");

    private final String status;

    WeaponStatus(String status) {
        this.status = status;
    }
}
