package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Employee;
import com.example.warehouse.mappers.EmployeeMapper;
import com.example.warehouse.models.EmployeeModel;
import com.example.warehouse.repositories.EmployeeRepository;
import com.example.warehouse.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeModel> getAllEmployees() {

        List<EmployeeModel> employees = employeeMapper.toModels(employeeRepository.findAll());

        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Employees does not exists");
        }

        return employees;
    }

    @Override
    public Optional<EmployeeModel> getEmployee(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employeeMapper.toOptionalModel(employee);
        }

        return Optional.empty();
    }

    @Override
    public EmployeeModel create(EmployeeModel createEmployee) {

        Employee saveEmployee = employeeMapper.toEntity(createEmployee);

        return employeeMapper.toModel(employeeRepository.save(saveEmployee));
    }

    @Override
    public EmployeeModel update(EmployeeModel updateEmployee) {

        Employee updatedEmployee = new Employee()
                .setId(updateEmployee.getId())
                .setFullName(updateEmployee.getFullName())
                .setRank(updateEmployee.getRank())
                .setPosition(updateEmployee.getPosition())
                .setDepartment(updateEmployee.getDepartment())
                .setPassportNumber(updateEmployee.getPassportNumber())
                .setServiceNumber(updateEmployee.getServiceNumber())
                .setActive(updateEmployee.isActive());

        return employeeMapper.toModel(employeeRepository.save(updatedEmployee));
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee existingEmployee = employeeMapper.toEntity(getEmployee(id).get());

        if (existingEmployee == null) {
            throw new IllegalArgumentException("Employee does not exists");
        }

        employeeRepository.deleteById(existingEmployee.getId());
    }
}
