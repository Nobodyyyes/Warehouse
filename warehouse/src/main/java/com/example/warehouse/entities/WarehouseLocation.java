package com.example.warehouse.entities;

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
@Table(name = "WAREHOUSE_LOCATION")
public class WarehouseLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WAREHOUSE_LOCATION_SEQ")
    @SequenceGenerator(name = "WAREHOUSE_LOCATION_SEQ", sequenceName = "WAREHOUSE_LOCATION_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "SECTION")
    private String section;

    @Column(name = "SHELF")
    private String shelf;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "warehouseLocation", cascade = CascadeType.ALL)
    private List<Weapon> weapons;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;
}
