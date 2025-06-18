package com.example.warehouse.mappers;

import com.example.warehouse.entities.Client;
import com.example.warehouse.models.ClientModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public Client toEntity(ClientModel model) {
        return new Client()
                .setId(model.getId())
                .setFullName(model.getFullName())
                .setPassportNumber(model.getPassportNumber())
                .setAddress(model.getAddress())
                .setPhoneNumber(model.getPhoneNumber());
    }

    public ClientModel toModel(Client entity) {
        return new ClientModel()
                .setId(entity.getId())
                .setFullName(entity.getFullName())
                .setPassportNumber(entity.getPassportNumber())
                .setAddress(entity.getAddress())
                .setPhoneNumber(entity.getPhoneNumber());
    }

    public List<Client> toEntities(List<ClientModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<ClientModel> toModels(List<Client> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Optional<ClientModel> toOptionalModel(Optional<Client> optionalEntity) {
        return optionalEntity.map(this::toModel);
    }
}
