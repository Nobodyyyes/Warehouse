package com.example.warehouse.services;

import com.example.warehouse.models.ClientModel;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientModel> getAllClients();

    Optional<ClientModel> getClientById(Long id);

    ClientModel createClient(ClientModel createClient);

    ClientModel updateClient(ClientModel updateClient);

    void deleteClient(Long id);
}
