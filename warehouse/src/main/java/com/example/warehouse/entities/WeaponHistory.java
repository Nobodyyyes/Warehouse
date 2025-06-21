package com.example.warehouse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "WEAPON_HISTORY")
public class WeaponHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEAPON_HISTORY_SEQ")
    @SequenceGenerator(name = "WEAPON_HISTORY_SEQ", sequenceName = "WEAPON_HISTORY_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "ISSUE_AT")
    private LocalDate issueAt;

    @Column(name = "RETURNED_AT")
    private LocalDate returnedAt;

    @Column(name = "NOTES")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee issuedBy;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client issuedTo;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_LOCATION_ID", nullable = false)
    private WarehouseLocation issuedFrom;

    @ManyToOne
    @JoinColumn(name = "WEAPON_ID", nullable = false)
    private Weapon weapon;
}
