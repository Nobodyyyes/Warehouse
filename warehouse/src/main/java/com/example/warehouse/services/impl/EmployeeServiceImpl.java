package com.example.warehouse.services.impl;

import com.example.warehouse.mappers.EmployeeMapper;
import com.example.warehouse.models.EmployeeModel;
import com.example.warehouse.repositories.EmployeeRepository;
import com.example.warehouse.services.EmployeeService;
import com.example.warehouse.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    /**
     * Получает список всех сотрудников.
     *
     * @return Список моделей сотрудников.
     */
    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeMapper.toModels(employeeRepository.findAll());
    }

    /**
     * Получает сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Optional, содержащий модель сотрудника, если сотрудник найден, или пустой Optional, если сотрудник не найден.
     */
    @Override
    public Optional<EmployeeModel> getEmployee(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toModel);
    }

    /**
     * Создает нового сотрудника.
     *
     * @param createEmployee Модель сотрудника, содержащая данные для создания.
     * @return Модель сотрудника, созданного в базе данных.
     */
    @Override
    public EmployeeModel create(EmployeeModel createEmployee) {
        return employeeMapper.toModel(employeeRepository.save(employeeMapper.toEntity(createEmployee)));
    }

    /**
     * Обновляет данные сотрудника.
     *
     * @param updateEmployee Модель сотрудника, содержащая обновленные данные.
     *                       Поле ID должно быть заполнено, чтобы указать, какой сотрудник обновляется.
     * @return Модель сотрудника после обновления в базе данных.
     * @throws IllegalArgumentException Если поле ID у модели сотрудника равно null.
     */
    @Override
    public EmployeeModel update(EmployeeModel updateEmployee) {

        ValidationUtils.checkOnNull(updateEmployee.getId());

        return employeeMapper.toModel(employeeRepository.save(employeeMapper.toEntity(updateEmployee)));
    }

    /**
     * Удаляет сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника, который нужно удалить.
     * @throws IllegalArgumentException Если сотрудник с указанным идентификатором не найден.
     */
    @Override
    public void deleteEmployee(Long id) {

        EmployeeModel removableEmployee = getEmployee(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID %s not found".formatted(id)));

        employeeRepository.deleteById(removableEmployee.getId());
    }
}
