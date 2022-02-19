package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.exception.NotFoundException;
import com.patika.paycore.ilkproje.model.Client;
import com.patika.paycore.ilkproje.model.Station;
import com.patika.paycore.ilkproje.repository.ClientDal;
import com.patika.paycore.ilkproje.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    @Autowired
    private ClientDal clientDal;

    @Override
    public List<Client> getAllClients() {
        return clientDal.findAll();
    }

    @Override
    public Client getClient(Integer id) {
        Optional<Client> byId = clientDal.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Client"));
    }

    @Override
    public boolean deleteClient(Integer id) {
        clientDal.deleteById(id);
        return true;
    }

    @Override
    public boolean addClient(Client client) {
        clientDal.save(client);
        return true;
    }

    @Override
    public boolean updateClient(Integer id, Client client) {
        client.setId(id);
        clientDal.save(client);
        return true;
    }



}
