package com.example.warehouse.services.impl;

import com.example.warehouse.mappers.WeaponHistoryMapper;
import com.example.warehouse.models.WeaponHistoryModel;
import com.example.warehouse.repositories.WeaponHistoryRepository;
import com.example.warehouse.services.WeaponHistoryService;
import com.example.warehouse.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponHistoryServiceImpl implements WeaponHistoryService {

    private final WeaponHistoryRepository weaponHistoryRepository;

    private final WeaponHistoryMapper weaponHistoryMapper;

    /**
     * Получает список всей истории оружия.
     *
     * @return Список моделей истории оружия.
     */
    @Override
    public List<WeaponHistoryModel> getAllHistory() {
        return weaponHistoryMapper.toModels(weaponHistoryRepository.findAll());
    }

    /**
     * Получает список истории оружия за указанный период.
     *
     * @param from Дата начала периода.
     * @param to   Дата окончания периода.
     * @return Список моделей истории оружия, соответствующих указанному периоду.
     */
    @Override
    public List<WeaponHistoryModel> getHistoryFromTo(LocalDate from, LocalDate to) {
        return weaponHistoryMapper.toModels(weaponHistoryRepository.findByIssueAtBetween(from, to));
    }

    /**
     * Получает историю оружия по её идентификатору.
     *
     * @param id Идентификатор истории оружия.
     * @return Optional, содержащий модель истории оружия, если запись найдена, или пустой Optional, если запись не найдена.
     */
    @Override
    public Optional<WeaponHistoryModel> getHistory(Long id) {
        return weaponHistoryRepository.findById(id)
                .map(weaponHistoryMapper::toModel);
    }

    /**
     * Создает новую запись истории оружия.
     *
     * @param model Модель истории оружия, содержащая данные для создания.
     *              Поле ID должно быть заполнено, чтобы указать идентификатор записи.
     * @return Модель истории оружия, созданной в базе данных.
     * @throws IllegalArgumentException Если поле ID у модели истории оружия равно null.
     */
    @Override
    public WeaponHistoryModel createWeaponHistory(WeaponHistoryModel model) {

        ValidationUtils.checkOnNull(model.getId());

        return weaponHistoryMapper.toModel(weaponHistoryRepository.save(weaponHistoryMapper.toEntity(model)));
    }

    /**
     * Удаляет запись истории оружия по её идентификатору.
     *
     * @param id Идентификатор записи истории оружия, которую нужно удалить.
     * @throws IllegalArgumentException Если запись с указанным идентификатором не найдена.
     */
    @Override
    public void deleteHistory(Long id) {

        WeaponHistoryModel removableHistory = getHistory(id)
                .orElseThrow(() -> new IllegalArgumentException("History with ID %s not found".formatted(id)));

        weaponHistoryRepository.deleteById(removableHistory.getId());
    }
}
