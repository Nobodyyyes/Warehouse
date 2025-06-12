package com.example.warehouse.repositories;

import com.example.warehouse.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

}
