package com.example.warehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WarehouseController {

    @GetMapping
    public String mainPage() {
        return "main/warehouse";
    }
}
