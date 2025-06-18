package com.example.warehouse.services.impl;

import com.example.warehouse.mappers.WeaponMapper;
import com.example.warehouse.models.WeaponModel;
import com.example.warehouse.repositories.WeaponRepository;
import com.example.warehouse.services.WeaponService;
import com.example.warehouse.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {

    private final WeaponRepository weaponRepository;

    private final WeaponMapper weaponMapper;

    /**
     * Получает список всех оружий.
     *
     * @return Список моделей оружий.
     */
    @Override
    public List<WeaponModel> getAllWeapons() {
        return weaponMapper.toModels(weaponRepository.findAll());
    }

    /**
     * Получает оружие по его идентификатору.
     *
     * @param id Идентификатор оружия.
     * @return Optional, содержащий модель оружия, если запись найдена, или пустой Optional, если запись не найдена.
     */
    @Override
    public Optional<WeaponModel> getWeaponById(Long id) {
        return weaponRepository.findById(id)
                .map(weaponMapper::toModel);
    }

    /**
     * Создает новое оружие.
     *
     * @param createWeaponModel Модель оружия, содержащая данные для создания.
     * @return Модель созданного оружия.
     */
    @Override
    public WeaponModel createWeapon(WeaponModel createWeaponModel) {
        return weaponMapper.toModel(weaponRepository.save(weaponMapper.toEntity(createWeaponModel)));
    }

    /**
     * Обновляет существующее оружие.
     *
     * @param updateWeaponModel Модель оружия, содержащая обновленные данные.
     *                          Поле ID должно быть заполнено, чтобы указать идентификатор записи.
     * @return Модель обновленного оружия.
     * @throws IllegalArgumentException Если поле ID у модели оружия равно null.
     */
    @Override
    public WeaponModel updateWeapon(WeaponModel updateWeaponModel) {

        ValidationUtils.checkOnNull(updateWeaponModel.getId());

        return weaponMapper.toModel(weaponRepository.save(weaponMapper.toEntity(updateWeaponModel)));
    }

    /**
     * Удаляет оружие по его идентификатору.
     *
     * @param id Идентификатор оружия, которое нужно удалить.
     * @throws IllegalArgumentException Если запись с указанным идентификатором не найдена.
     */
    @Override
    public void deleteWeapon(Long id) {

        WeaponModel removableWeapon = getWeaponById(id)
                .orElseThrow(() -> new IllegalArgumentException("Weapon with ID %s not found".formatted(id)));

        weaponRepository.deleteById(removableWeapon.getId());
    }
}
