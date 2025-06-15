package com.example.warehouse.controllers;

import com.example.warehouse.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
