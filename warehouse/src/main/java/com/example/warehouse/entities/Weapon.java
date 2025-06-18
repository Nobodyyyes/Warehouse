package com.example.warehouse.entities;

import com.example.warehouse.enums.WeaponStatus;
import com.example.warehouse.enums.WeaponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "WEAPON")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEAPON_SEQ")
    @SequenceGenerator(name = "WEAPON_SEQ", sequenceName = "WEAPON_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "WEAPON_TYPE")
    private WeaponType weaponType;

    @Column(name = "CALIBER")
    private String caliber;

    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @Column(name = "PRODUCTION_DATE")
    private LocalDate productionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "WEAPON_STATUS")
    private WeaponStatus weaponStatus;

    @Column(name = "ISSUED_EMPLOYEE_ID")
    private Long issuedEmployeeId; // ID сотрудника, который выдал текущее оружие

    @Column(name = "CLIENT_ID")
    private Long clientId; // ID клиента, который купил текущее оружие

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_LOCATION_ID")
    private WarehouseLocation warehouseLocation;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToMany(mappedBy = "weapon", cascade = CascadeType.ALL)
    private List<WeaponHistory> weaponHistories;
}
