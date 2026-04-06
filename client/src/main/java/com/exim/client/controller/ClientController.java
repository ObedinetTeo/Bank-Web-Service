package com.exim.client.controller;

import com.exim.client.dto.ClientResponse;
import com.exim.client.entity.DetaliiClientView;
import com.exim.client.service.ClientService;
import com.exim.client.dto.ClientRequest;
import com.exim.client.entity.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/clienti")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/cod/{codClient}")
    public ClientResponse getByCodClient(@PathVariable String codClient) {
        return clientService.getByCodClient(codClient);
    }
    

    @GetMapping("/profil/{codClient}")
    public DetaliiClientView getCompleteProfile(@PathVariable String codClient) {
        return clientService.getCompleteProfile(codClient);
    }

    @GetMapping("/nume/{nume}")
    public List<ClientResponse> searchByName(@PathVariable String nume) {
        return clientService.searchByName(nume);
    }

    @GetMapping
    public List<ClientResponse> search(
            @RequestParam(required = false) String nume,
            @RequestParam(required = false) Boolean status) {

        if (nume != null && !nume.isBlank()) {
            return clientService.searchByName(nume);
        }
        if (status != null) {
            return clientService.searchByStatus(status);
        }
        throw new IllegalArgumentException("Trimite parametrul nume sau status");
    }

    @GetMapping("/tara/{tara}")
    public List<DetaliiClientView> searchByTara(@PathVariable String tara) {
        return clientService.searchByTara(tara);
    }

    @GetMapping("/oras/{oras}")
    public List<DetaliiClientView> searchByOras(@PathVariable String oras) {
        return clientService.searchByOras(oras);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody ClientRequest client){
        Client savedClient = clientService.createNewClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }
    
}
