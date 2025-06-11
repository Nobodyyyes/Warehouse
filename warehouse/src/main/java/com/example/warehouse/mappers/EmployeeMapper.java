package com.example.warehouse.mappers;

import com.example.warehouse.entities.Employee;
import com.example.warehouse.models.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeModel employeeModel) {
        return new Employee()
                .setId(employeeModel.getId())
                .setFullName(employeeModel.getFullName())
                .setRank(employeeModel.getRank())
                .setPosition(employeeModel.getPosition())
                .setDepartment(employeeModel.getDepartment())
                .setPassportNumber(employeeModel.getPassportNumber())
                .setServiceNumber(employeeModel.getServiceNumber())
                .setActive(employeeModel.isActive());
    }

    public EmployeeModel toModel(Employee employee) {
        return new EmployeeModel()
                .setId(employee.getId())
                .setFullName(employee.getFullName())
                .setRank(employee.getRank())
                .setPosition(employee.getPosition())
                .setDepartment(employee.getDepartment())
                .setPassportNumber(employee.getPassportNumber())
                .setServiceNumber(employee.getServiceNumber())
                .setActive(employee.isActive());
    }

    public List<Employee> toEntities(List<EmployeeModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<EmployeeModel> toModels(List<Employee> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Optional<EmployeeModel> toOptionalModel(Optional<Employee> employeeOptional) {
        return employeeOptional.map(this::toModel);
    }
}
