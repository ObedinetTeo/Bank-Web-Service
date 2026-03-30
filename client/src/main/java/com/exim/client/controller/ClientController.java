package com.exim.client.controller;

import com.exim.client.dto.ClientResponse;
import com.exim.client.dto.UpdateClientRequest;
import com.exim.client.service.ClientService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ClientResponse getById(@PathVariable Integer id) {
        return clientService.getById(id);
    }

    @GetMapping("/cod/{codClient}")
    public ClientResponse getByCodClient(@PathVariable String codClient) {
        return clientService.getByCodClient(codClient);
    }

    // @GetMapping
    // public List<ClientResponse> search(
    //         @RequestParam(required = false) String name,
    //         @RequestParam(required = false) String status) {

    //     if (name != null && !name.isBlank()) {
    //         return clientService.searchByName(name);
    //     }
    //     if (status != null && !status.isBlank()) {
    //         return clientService.searchByStatus(status);
    //     }
    //     throw new IllegalArgumentException("Trimite parametrul name sau status");
    // }
}
