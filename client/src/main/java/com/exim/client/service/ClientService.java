package com.exim.client.service;

import com.exim.client.dto.ClientResponse;
import com.exim.client.entity.Client;
import com.exim.client.entity.DetaliiClientView;
import com.exim.client.exception.ResourceNotFoundException;
import com.exim.client.repository.ClientRepository;
import com.exim.client.repository.DetaliiClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;      

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DetaliiClientRepository detaliiClientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponse getByCodClient(String codClient) {
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("Clientul nu a fost gasit"));
        return mapToResponse(client);
    }

    public List<ClientResponse> searchByName(String nume, String prenume) {
        return clientRepository.findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(nume, prenume)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public DetaliiClientView obtineProfilComplet(String codClient) {
        return detaliiClientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new RuntimeException("Eroare: Nu am putut gasi detaliile pentru clientul " + codClient));
    }

    private ClientResponse mapToResponse(Client client) {
        ClientResponse response = new ClientResponse();
        response.setCodClient(client.getCodClient());
        response.setCnp(client.getCnp());
        response.setActId(client.getActId());
        response.setNume(client.getNume());
        response.setPrenume(client.getPrenume());
        response.setStatus(client.getStatus());
        return response;
    }

    public ClientResponse getById(Integer id) {
        Client client = clientRepository.findAllById(id.longValue())
                .orElseThrow(() -> new ResourceNotFoundException("Clientul nu a fost gasit"));
        return mapToResponse(client);
    }
}
