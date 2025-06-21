package com.example.warehouse.enums.weapon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeaponType {

    PISTOL("Пистолет"),
    RIFLE("Штурмовой"),
    SMG("Пистолет-пулемет"),
    SHOTGUN("Дробович");

    private final String description;
}
