package com.example.warehouse.enums.weapon;

import lombok.Getter;

@Getter
public enum WeaponType {

    PISTOL("Пистолет"),
    RIFLE("Штурмовой"),
    SMG("Пистолет-пулемет"),
    SHOTGUN("Дробовик");

    private final String description;

    WeaponType(String description) {
        this.description = description;
    }
}
