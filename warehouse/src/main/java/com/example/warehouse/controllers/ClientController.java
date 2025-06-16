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
        model.addAttribute("clients", clientService.getAllClients());
        return "client/clientList";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("client", new ClientModel());
        return "client/clientNew";
    }

    @PostMapping("/new")
    public String createClient(@ModelAttribute("client") ClientModel clientModel) {
        clientService.createClient(clientModel);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ClientModel clientModel = clientService.getClientById(id).get();
        model.addAttribute("client", clientModel);
        return "client/clientEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute ClientModel clientModel) {
        clientModel.setId(id);
        clientService.updateClient(clientModel);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
