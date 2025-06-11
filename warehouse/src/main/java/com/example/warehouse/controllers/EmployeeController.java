package com.example.warehouse.controllers;

import com.example.warehouse.models.EmployeeModel;
import com.example.warehouse.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/employeeList";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        EmployeeModel employee = employeeService.getEmployee(id).get();
        model.addAttribute("employee", employee);
        return "employee/employeeEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute EmployeeModel employee) {
        employee.setId(id);
        employeeService.update(employee);
        return "redirect:/employees";
    }
}
