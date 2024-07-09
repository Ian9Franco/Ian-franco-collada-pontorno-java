package com.abmpf.abmpf.service;

import com.abmpf.abmpf.entities.Client;
import com.abmpf.abmpf.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }
}
