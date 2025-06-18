package com.example.warehouse.services.impl;

import com.example.warehouse.mappers.ClientMapper;
import com.example.warehouse.models.ClientModel;
import com.example.warehouse.repositories.ClientRepository;
import com.example.warehouse.services.ClientService;
import com.example.warehouse.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    /**
     * Получает список всех клиентов.
     *
     * @return Список моделей клиентов.
     */
    @Override
    public List<ClientModel> getAllClients() {
        return clientMapper.toModels(clientRepository.findAll());
    }

    /**
     * Получает клиента по его идентификатору.
     *
     * @param id Идентификатор клиента.
     * @return Optional, содержащий модель клиента, если клиент найден, или пустой Optional, если клиент не найден.
     */
    @Override
    public Optional<ClientModel> getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toModel);
    }

    /**
     * Создает нового клиента.
     *
     * @param createClient Модель клиента, содержащая данные для создания.
     * @return Модель клиента, созданного в базе данных.
     */
    @Override
    public ClientModel createClient(ClientModel createClient) {
        return clientMapper.toModel(clientRepository.save(clientMapper.toEntity(createClient)));
    }

    /**
     * Обновляет данные клиента.
     *
     * @param updateClient Модель клиента, содержащая обновленные данные.
     *                     Поле ID должно быть заполнено, чтобы указать, какой клиент обновляется.
     * @return Модель клиента после обновления в базе данных.
     * @throws IllegalArgumentException Если поле ID у модели клиента равно null.
     */
    @Override
    public ClientModel updateClient(ClientModel updateClient) {

        ValidationUtils.checkOnNull(updateClient.getId());

        return clientMapper.toModel(clientRepository.save(clientMapper.toEntity(updateClient)));
    }

    /**
     * Удаляет клиента по его идентификатору.
     *
     * @param id Идентификатор клиента, который нужно удалить.
     * @throws IllegalArgumentException Если клиент с указанным идентификатором не найден.
     */
    @Override
    public void deleteClient(Long id) {

        ClientModel removableClient = getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID %s not found".formatted(id)));

        clientRepository.deleteById(removableClient.getId());
    }
}
