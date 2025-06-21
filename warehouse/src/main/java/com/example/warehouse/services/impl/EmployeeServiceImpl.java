package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Employee;
import com.example.warehouse.mappers.BaseMapper;
import com.example.warehouse.models.EmployeeModel;
import com.example.warehouse.services.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeModel, Employee, Long> implements EmployeeService {

    public EmployeeServiceImpl(JpaRepository<Employee, Long> repository, BaseMapper<EmployeeModel, Employee> baseMapper) {
        super(repository, baseMapper);
    }
}
