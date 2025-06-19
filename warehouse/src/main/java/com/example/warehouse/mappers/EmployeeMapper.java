package com.example.warehouse.mappers;

import com.example.warehouse.entities.Employee;
import com.example.warehouse.models.EmployeeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper implements BaseMapper<EmployeeModel, Employee> {

    private final WeaponMapper weaponMapper;

    public Employee toEntity(EmployeeModel employeeModel) {
        return new Employee()
                .setId(employeeModel.getId())
                .setFullName(employeeModel.getFullName())
                .setRank(employeeModel.getRank())
                .setPosition(employeeModel.getPosition())
                .setDepartment(employeeModel.getDepartment())
                .setPassportNumber(employeeModel.getPassportNumber())
                .setServiceNumber(employeeModel.getServiceNumber())
                .setIsActive(employeeModel.getIsActive());
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
                .setIsActive(employee.getIsActive())
                .setWeapons(weaponMapper.toModels(employee.getWeapons()));
    }
}
