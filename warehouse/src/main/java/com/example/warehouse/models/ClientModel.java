package com.example.warehouse.models;

import com.example.warehouse.entities.Weapon;
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
public class ClientModel {

    private Long id;
    private String fullName;
    private String passportNumber;
    private String address;
    private String phoneNumber;
    private List<Weapon> purchasedWeapons;
}
