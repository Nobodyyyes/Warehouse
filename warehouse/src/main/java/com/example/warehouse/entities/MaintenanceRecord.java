package com.example.warehouse.entities;

import com.example.warehouse.enums.MaintenanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MAINTENANCE_RECORD")
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAINTENANCE_RECORD_SEQ")
    @SequenceGenerator(name = "MAINTENANCE_RECORD_SEQ", sequenceName = "MAINTENANCE_RECORD_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "WEAPON_ID", nullable = false)
    private Weapon weapon;

    @Column(name = "PERFORMED_AT")
    private LocalDate performedAt;

    @Column(name = "PERFORMED_BY")
    private String performedBy;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "MAINTENANCE_STATUS")
    private MaintenanceStatus maintenanceStatus;
}
