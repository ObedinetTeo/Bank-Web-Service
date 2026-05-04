package com.exim.client.controller;

import com.exim.client.dto.ClientResponse;
import com.exim.client.dto.UpdateClientRequest;
import com.exim.client.dto.UpdateAdresaRequest;
import com.exim.client.dto.UpdateContactRequest;
import com.exim.client.entity.DetaliiClientView;
import com.exim.client.exception.DuplicateResourceException;
import com.exim.client.entity.Adresa;
import com.exim.client.entity.Contact;
import com.exim.client.repository.ClientRepository;
import com.exim.client.service.ClientService;

import jakarta.validation.Valid;

import com.exim.client.dto.ClientRequest;
import com.exim.client.entity.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/code/{codClient}")
    public ClientResponse getByCodClient(@PathVariable String codClient) {
        return clientService.getByCodClient(codClient);
    }
    

    @GetMapping("/profile/{codClient}")
    public DetaliiClientView getCompleteProfile(@PathVariable String codClient) {
        return clientService.getCompleteProfile(codClient);
    }

    @GetMapping("/name/{nume}")
    public List<ClientResponse> searchByName(@PathVariable String nume) {
        return clientService.searchByName(nume);
    }

    // testing example: http://localhost:8080/api/clienti?nume=Popescu
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
        throw new IllegalArgumentException("Send at least one search parameter: last name or status (true/false)!");
    }

    @GetMapping("/country/{tara}")
    public List<DetaliiClientView> searchByTara(@PathVariable String tara) {
        return clientService.searchByTara(tara);
    }

    @GetMapping("/city/{oras}")
    public List<DetaliiClientView> searchByOras(@PathVariable String oras) {
        return clientService.searchByOras(oras);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@Valid @RequestBody ClientRequest client){
        if (clientRepository.existsByCnp(client.getCnp()) || clientRepository.existsByActId(client.getActId()))
        {
            throw new DuplicateResourceException("A client with the same CNP or ActId already exists!");
        }
        Client savedClient = clientService.createNewClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @DeleteMapping("/delete/{codClient}")
    public ResponseEntity<String> deleteClientLogical(@PathVariable String codClient) {
        clientService.deleteClientLogical(codClient);
        return ResponseEntity.ok("The clients " + codClient + " was successfully logically deleted!");
    }

    @PutMapping("/update/{codClient}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable String codClient, @RequestBody UpdateClientRequest request) {
        ClientResponse response = clientService.updateClient(codClient, request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/adresa/update/{codClient}/{tipAdresa}")
    public ResponseEntity<Adresa> updateAdresa(@PathVariable String codClient, @PathVariable String tipAdresa, @RequestBody UpdateAdresaRequest request) {
        Adresa adresa = clientService.updateAdresa(codClient, tipAdresa, request);
        return ResponseEntity.ok(adresa);
    }

    @PutMapping("/contact/update/{codClient}")
    public ResponseEntity<Contact> updateContact(@PathVariable String codClient, @RequestBody UpdateContactRequest request) {
        Contact contact = clientService.updateContact(codClient, request);
        return ResponseEntity.ok(contact);
    }
    
}
