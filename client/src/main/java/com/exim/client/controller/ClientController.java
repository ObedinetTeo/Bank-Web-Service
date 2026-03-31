package com.exim.client.controller;

import com.exim.client.dto.ClientResponse;
import com.exim.client.entity.DetaliiClientView;
import com.exim.client.service.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/{nume}")
    public List<ClientResponse> searchByName(@PathVariable String nume) {
        return clientService.searchByName(nume);
    }

    @GetMapping
    public List<ClientResponse> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean status) {

        if (name != null && !name.isBlank()) {
            return clientService.searchByName(name);
        }
        if (status != null) {
            return clientService.searchByStatus(status);
        }
        throw new IllegalArgumentException("Trimite parametrul name sau status");
    }
}
