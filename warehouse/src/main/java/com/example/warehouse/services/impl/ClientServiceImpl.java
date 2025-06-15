package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Client;
import com.example.warehouse.mappers.ClientMapper;
import com.example.warehouse.models.ClientModel;
import com.example.warehouse.repositories.ClientRepository;
import com.example.warehouse.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Override
    public List<ClientModel> getAllClients() {

        List<ClientModel> clientModels = clientMapper.toModels(clientRepository.findAll());

        if (clientModels.isEmpty()) {
            throw new IllegalArgumentException("Clients does not exists");
        }

        return clientModels;
    }

    @Override
    public Optional<ClientModel> getClientById(Long id) {

        return clientMapper.toOptionalModel(clientRepository.findById(id));
    }

    @Override
    public ClientModel createClient(ClientModel createClient) {

        Client newClient = clientMapper.toEntity(createClient);

        return clientMapper.toModel(clientRepository.save(newClient));
    }

    @Override
    public ClientModel updateClient(ClientModel updateClient) {

        Client updatedClient = new Client()
                .setId(updateClient.getId())
                .setFullName(updateClient.getFullName())
                .setPassportNumber(updateClient.getPassportNumber())
                .setAddress(updateClient.getAddress())
                .setPhoneNumber(updateClient.getPhoneNumber())
                .setPurchasedWeapons(updateClient.getPurchasedWeapons());

        return clientMapper.toModel(clientRepository.save(updatedClient));
    }

    @Override
    public void deleteClient(Long id) {

        Client deleteClient = clientMapper.toEntity(getClientById(id).get());

        if (deleteClient == null) {
            throw new IllegalArgumentException("Client with id %s does not exists".formatted(id));
        }

        clientRepository.deleteById(deleteClient.getId());
    }
}
