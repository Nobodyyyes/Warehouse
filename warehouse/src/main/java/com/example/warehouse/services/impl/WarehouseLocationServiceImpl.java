package com.example.warehouse.services.impl;

import com.example.warehouse.mappers.WarehouseLocationMapper;
import com.example.warehouse.models.WarehouseLocationModel;
import com.example.warehouse.repositories.WarehouseLocationRepository;
import com.example.warehouse.services.WarehouseLocationService;
import com.example.warehouse.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseLocationServiceImpl implements WarehouseLocationService {

    private final WarehouseLocationRepository warehouseLocationRepository;

    private final WarehouseLocationMapper warehouseLocationMapper;

    /**
     * Возвращает список всех местоположений склада.
     *
     * @return список объектов {@link WarehouseLocationModel}, представляющих все местоположения склада.
     */
    @Override
    public List<WarehouseLocationModel> getAllLocations() {
        return warehouseLocationMapper.toModels(warehouseLocationRepository.findAll());
    }

    /**
     * Возвращает местоположение склада по указанному идентификатору.
     *
     * @param id идентификатор местоположения склада.
     * @return объект {@link Optional}, содержащий {@link WarehouseLocationModel}, если местоположение найдено.
     */
    @Override
    public Optional<WarehouseLocationModel> getLocation(Long id) {
        return warehouseLocationRepository.findById(id)
                .map(warehouseLocationMapper::toModel);
    }

    /**
     * Создаёт новое местоположение склада.
     *
     * @param newLocation объект {@link WarehouseLocationModel}, представляющий новое местоположение склада.
     * @return объект {@link WarehouseLocationModel}, представляющий созданное местоположение склада.
     */
    @Override
    public WarehouseLocationModel createLocation(WarehouseLocationModel newLocation) {
        return warehouseLocationMapper.toModel(warehouseLocationRepository.save(warehouseLocationMapper.toEntity(newLocation)));
    }

    /**
     * Обновляет существующее местоположение склада.
     *
     * @param updatableLocation объект {@link WarehouseLocationModel}, представляющий обновляемое местоположение склада.
     *                          Должен содержать идентификатор.
     * @return объект {@link WarehouseLocationModel}, представляющий обновлённое местоположение склада.
     * @throws IllegalArgumentException если идентификатор обновляемого местоположения равен null.
     */
    @Override
    public WarehouseLocationModel updateLocation(WarehouseLocationModel updatableLocation) {

        ValidationUtils.checkOnNull(updatableLocation.getId());

        return warehouseLocationMapper.toModel(warehouseLocationRepository.save(warehouseLocationMapper.toEntity(updatableLocation)));
    }

    /**
     * Удаляет местоположение склада по указанному идентификатору.
     *
     * @param id идентификатор местоположения склада.
     * @throws IllegalArgumentException если местоположение с указанным идентификатором не найдено.
     */
    @Override
    public void deleteLocation(Long id) {

        WarehouseLocationModel removableLocation = getLocation(id)
                .orElseThrow(() -> new IllegalArgumentException("Location with ID %s not found".formatted(id)));

        warehouseLocationRepository.deleteById(removableLocation.getId());
    }
}
