package com.example.warehouse.controllers;

import com.example.warehouse.enums.WeaponStatus;
import com.example.warehouse.enums.WeaponType;
import com.example.warehouse.models.EmployeeModel;
import com.example.warehouse.models.WeaponModel;
import com.example.warehouse.services.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weapons")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponService weaponService;

    @GetMapping
    public String listWeapons(Model model) {
        model.addAttribute("weapons", weaponService.getAllWeapons());
        return "weapon/weaponList";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("weapon", new WeaponModel());
        model.addAttribute("weaponType", WeaponType.values());
        model.addAttribute("weaponStatus", WeaponStatus.values());
        return "weapon/weaponNew";
    }

    @PostMapping("/new")
    public String createWeapon(@ModelAttribute("weapon") WeaponModel weaponModel) {
        weaponService.createWeapon(weaponModel);
        return "redirect:/weapons";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        WeaponModel weapon = weaponService.getWeaponById(id).get();
        model.addAttribute("weapon", weapon);
        return "weapon/weaponEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute WeaponModel weapon) {
        weapon.setId(id);
        weaponService.updateWeapon(weapon);
        return "redirect:/weapons";
    }
}
