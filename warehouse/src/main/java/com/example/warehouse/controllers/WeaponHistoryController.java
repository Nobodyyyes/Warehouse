package com.example.warehouse.controllers;

import com.example.warehouse.models.WeaponHistoryModel;
import com.example.warehouse.services.WeaponHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weapon/history")
@RequiredArgsConstructor
public class WeaponHistoryController {

    private final WeaponHistoryService weaponHistoryService;

    @GetMapping
    public String weaponHistoryList(Model model) {
        model.addAttribute("weaponHistory", weaponHistoryService.getAll());
        return "weaponHistory/weaponHistoryList";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("weaponHistory", new WeaponHistoryModel());
        return "weaponHistory/weaponHistoryNew";
    }

    @PostMapping("/new")
    public String createEmployee(@ModelAttribute("weaponHistory") WeaponHistoryModel weaponHistoryModel) {
        weaponHistoryService.save(weaponHistoryModel);
        return "redirect:/weapon/history";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        weaponHistoryService.deleteById(id);
        return "redirect:/weapon/history";
    }
}
