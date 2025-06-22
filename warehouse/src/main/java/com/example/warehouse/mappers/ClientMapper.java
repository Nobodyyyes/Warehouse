package com.example.warehouse.mappers;

import com.example.warehouse.entities.Client;
import com.example.warehouse.models.ClientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper implements BaseMapper<ClientModel, Client> {

    private final WeaponMapper weaponMapper;

    private final WeaponHistoryMapper weaponHistoryMapper;

    public Client toEntity(ClientModel model) {
        return new Client()
                .setId(model.getId())
                .setFullName(model.getFullName())
                .setPassportNumber(model.getPassportNumber())
                .setAddress(model.getAddress())
                .setPhoneNumber(model.getPhoneNumber())
                .setPurchasedWeapons(weaponMapper.toEntities(model.getPurchasedWeapons()));
    }

    public ClientModel toModel(Client entity) {
        return new ClientModel()
                .setId(entity.getId())
                .setFullName(entity.getFullName())
                .setPassportNumber(entity.getPassportNumber())
                .setAddress(entity.getAddress())
                .setPhoneNumber(entity.getPhoneNumber())
                .setPurchasedWeapons(weaponMapper.toModels(entity.getPurchasedWeapons()))
                .setIssuedHistories(weaponHistoryMapper.toModels(entity.getIssuedHistories()));
    }
}
