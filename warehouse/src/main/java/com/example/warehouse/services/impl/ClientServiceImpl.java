package com.example.warehouse.services.impl;

import com.example.warehouse.entities.Client;
import com.example.warehouse.mappers.BaseMapper;
import com.example.warehouse.models.ClientModel;
import com.example.warehouse.services.ClientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientModel, Client, Long> implements ClientService {

    public ClientServiceImpl(JpaRepository<Client, Long> repository, BaseMapper<ClientModel, Client> baseMapper) {
        super(repository, baseMapper);
    }
}
