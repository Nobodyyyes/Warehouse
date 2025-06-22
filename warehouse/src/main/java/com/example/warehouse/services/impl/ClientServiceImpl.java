package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Client;
import com.example.warehouse.mappers.ClientMapper;
import com.example.warehouse.models.ClientModel;
import com.example.warehouse.models.WeaponModel;
import com.example.warehouse.repositories.ClientRepository;
import com.example.warehouse.services.ClientService;
import com.example.warehouse.services.WeaponService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientModel, Client, Long> implements ClientService {

    private final ClientRepository clientRepository;

    private final WeaponService weaponService;

    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, WeaponService weaponService, ClientMapper clientMapper) {
        super(clientRepository, clientMapper);
        this.clientRepository = clientRepository;
        this.weaponService = weaponService;
        this.clientMapper = clientMapper;
    }

    @Override
    public void removeWeapon(Long clientId, Long weaponId) {

        ClientModel clientModel = getById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID %s not found"));

        WeaponModel weaponModel = weaponService.getById(weaponId)
                .orElseThrow(() -> new IllegalArgumentException("Weapon with ID %s not found"));

        clientModel.getPurchasedWeapons().removeIf(weapon -> weapon.getId().equals(weaponModel.getId()));
        //todo: fix remove client weapon

        update(clientId, clientModel);
    }
}
