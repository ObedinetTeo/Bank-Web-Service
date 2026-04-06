package com.exim.client.service;

import com.exim.client.dto.ClientResponse;
import com.exim.client.entity.Adresa;
import com.exim.client.entity.Client;
import com.exim.client.entity.Contact;
import com.exim.client.entity.DetaliiClientView;
import com.exim.client.exception.ResourceNotFoundException;
import com.exim.client.model.TipAdresa;
import com.exim.client.repository.AdresaRepository;
import com.exim.client.repository.ClientRepository;
import com.exim.client.repository.ContactRepository;
import com.exim.client.repository.DetaliiClientRepository;
import com.exim.client.dto.ClientRequest;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;      

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdresaRepository adresaRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private DetaliiClientRepository detaliiClientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private String generarteNewCodClient() {
        String lastCodClient = clientRepository.findMaxCodClient();
        if (lastCodClient == null || lastCodClient.trim().isEmpty()) {
            return "C001"; 
        }
        try {
            int lastCodClientNr = Integer.parseInt(lastCodClient.substring(1));
            int newNr = lastCodClientNr + 1;
            return String.format("C%03d", newNr);
            
        } catch (Exception e) {
            return "C001";
        }
    }

    public ClientResponse getByCodClient(String codClient) {
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("Clientul nu a fost gasit"));
        return mapToResponse(client);
    }

    public List<ClientResponse> searchByName(String nume) {
        return clientRepository.findByNumeContainingIgnoreCase(nume)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<ClientResponse> searchByStatus(Boolean status) {
		return clientRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .toList();
	}

    public DetaliiClientView getCompleteProfile(String codClient) {
        return detaliiClientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new RuntimeException("Eroare: Nu am putut gasi detaliile pentru clientul " + codClient));
    }

    public List<DetaliiClientView> searchByTara(String tara) {
        return detaliiClientRepository.findByTara(tara);
    }

    public List<DetaliiClientView> searchByOras(String oras) {
        return detaliiClientRepository.findByOras(oras);
    }

    @Transactional
    public Client createNewClient(ClientRequest clientRequest){
        Client newClient = new Client();
        newClient.setCodClient(generarteNewCodClient());
        newClient.setNume(clientRequest.getNume());
        newClient.setPrenume(clientRequest.getPrenume());
        newClient.setCnp(clientRequest.getCnp());
        newClient.setActId(clientRequest.getActId());
        newClient.setStatus(true);

        Client savedClient = clientRepository.save(newClient);

        Adresa adresa = new Adresa();
        adresa.setIdClient(savedClient.getIdClient());
        adresa.setTara(clientRequest.getAdresa().getTara());
        adresa.setOras(clientRequest.getAdresa().getOras());
        adresa.setStrada(clientRequest.getAdresa().getStrada());
        adresa.setNumar(clientRequest.getAdresa().getNr());
        adresa.setTipAdresa(TipAdresa.valueOf(clientRequest.getAdresa().getTipAdresa())); 
        adresa.setStatus(true);
        adresaRepository.save(adresa);

        Contact contact = new Contact();
        contact.setIdClient(savedClient.getIdClient());
        contact.setTelMobil(clientRequest.getContact().getTelefon());
        contact.setEmail(clientRequest.getContact().getEmail());
        contact.setStatus(true);
        contactRepository.save(contact);

        return savedClient;
    }

    public ClientResponse mapToResponse(Client client) {
        ClientResponse response = new ClientResponse();
        response.setCodClient(client.getCodClient());
        response.setCnp(client.getCnp());
        response.setActId(client.getActId());
        response.setNume(client.getNume());
        response.setPrenume(client.getPrenume());
        response.setStatus(client.getStatus());
        return response;
    }

}
