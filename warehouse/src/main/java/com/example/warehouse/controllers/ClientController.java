package com.example.warehouse.controllers;

import com.example.warehouse.models.ClientModel;
import com.example.warehouse.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String clientList(Model model) {
        model.addAttribute("clients", clientService.getAll());
        return "client/clientList";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("client", new ClientModel());
        return "client/clientNew";
    }

    @PostMapping("/new")
    public String createClient(@ModelAttribute("client") ClientModel clientModel) {
        clientService.save(clientModel);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ClientModel clientModel = clientService.getById(id).get();
        model.addAttribute("client", clientModel);
        return "client/clientEdit";
    }

    @GetMapping("/{id}/remove-weapon/{weaponId}")
    public String removeClientWeapon(@PathVariable Long id,
                                     @PathVariable Long weaponId) {

    }

    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute ClientModel clientModel) {
        clientModel.setId(id);
        clientService.update(clientModel.getId(), clientModel);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }
}
