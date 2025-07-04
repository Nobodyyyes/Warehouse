package com.example.warehouse.services;

import com.example.warehouse.models.ClientModel;

public interface ClientService extends BaseService<ClientModel, Long> {

    void removeWeapon(Long clientId, Long weaponId);
}
