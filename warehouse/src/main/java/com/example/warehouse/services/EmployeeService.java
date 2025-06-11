package com.example.warehouse.services;

import com.example.warehouse.models.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeModel> getAllEmployees();

    Optional<EmployeeModel> getEmployee(Long id);

    EmployeeModel create(EmployeeModel createEmployee);

    EmployeeModel update(EmployeeModel updateEmployee);

    void deleteEmployee(Long id);
}
