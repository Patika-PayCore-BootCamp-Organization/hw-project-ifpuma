package com.patika.paycore.ilkproje.service;

import com.patika.paycore.ilkproje.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {

    List<Client> getAllClients();

    Optional<Client> getClient (Integer id);

    boolean deleteClient(Integer id);

    boolean addClient(Client client);

    boolean updateClient(Integer id,Client client);

}
