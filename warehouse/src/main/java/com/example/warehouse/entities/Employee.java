package com.example.warehouse.entities;

import com.example.warehouse.enums.EmployeePosition;
import com.example.warehouse.enums.EmployeeRank;
import jakarta.persistence.*;
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
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    @SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "RANK")
    @Enumerated(EnumType.STRING)
    private EmployeeRank rank;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private EmployeePosition position;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;

    @Column(name = "SERVICE_NUMBER")
    private String serviceNumber;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Weapon> weapons;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<WarehouseLocation> warehouseLocations;
}
