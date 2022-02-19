package com.patika.paycore.ilkproje.controller;

import com.patika.paycore.ilkproje.model.Client;
import com.patika.paycore.ilkproje.service.iml.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "/all")
    public List<Client> getAll(){
        List<Client> allClients = clientService.getAllClients();
        return allClients.stream().collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public Client getByIdClient(@PathVariable @Min(1) Integer id){
        return clientService.getClient(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteClient(@RequestParam @Min(1) Integer id){
        return clientService.deleteClient(id);
    }

    @PostMapping(value = "/create")
    public boolean saveClient(@RequestBody @Valid Client client){
        return clientService.addClient(client);
    }

    @PostMapping(value = "/update/{id}")
    public boolean updateClient(@PathVariable @Min(1) Integer id,@RequestBody Client client){
        return clientService.updateClient(id,client);
    }
    
}
