package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Client;
import com.example.warehouse.mappers.ClientMapper;
import com.example.warehouse.models.ClientModel;
import com.example.warehouse.repositories.ClientRepository;
import com.example.warehouse.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientModel, Client, Long> implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        super(clientRepository, clientMapper);
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public void removeWeapon(Long clientId, Long weaponId) {
        ClientModel clientModel = getById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID %s not found"));
    }
}
