package com.example.warehouse.entities;

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
@Table(name = "WEAPON_HISTORY")
public class WeaponHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEAPON_HISTORY_SEQ")
    @SequenceGenerator(name = "WEAPON_HISTORY_SEQ", sequenceName = "WEAPON_HISTORY_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "WEAPON_ID", nullable = false)
    private Weapon weapon;

    @ManyToOne
    @JoinColumn(name = "EMPOYEE_ID", nullable = false)
    private Employee employee;

    @Column(name = "ISSUE_AT")
    private LocalDate issueAt;

    @Column(name = "RETURNED_AT")
    private LocalDate returnedAt;

    @Column(name = "ISSUED_BY")
    private String issuedBy; // ФИО, кто выдал

    @Column(name = "NOTES")
    private String notes;
}
