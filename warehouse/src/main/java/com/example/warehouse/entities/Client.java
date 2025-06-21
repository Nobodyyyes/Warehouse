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
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
    @SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "PASSPORT_NUMBER", nullable = false, unique = true)
    private String passportNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Weapon> purchasedWeapons;

    @OneToMany(mappedBy = "issuedTo")
    private List<WeaponHistory> issuedHistories;
}
