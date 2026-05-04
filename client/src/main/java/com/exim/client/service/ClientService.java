package com.exim.client.service;

import com.exim.client.dto.ClientResponse;
import com.exim.client.dto.UpdateClientRequest;
import com.exim.client.dto.UpdateAdresaRequest;
import com.exim.client.dto.UpdateContactRequest;
import com.exim.client.entity.Adresa;
import com.exim.client.entity.Client;
import com.exim.client.entity.Contact;
import com.exim.client.entity.Cont;
import com.exim.client.entity.DetaliiClientView;
import com.exim.client.exception.ResourceNotFoundException;
import com.exim.client.model.TipAdresa;
import com.exim.client.repository.AdresaRepository;
import com.exim.client.repository.ClientRepository;
import com.exim.client.repository.ContactRepository;
import com.exim.client.repository.DetaliiClientRepository;
import com.exim.client.dto.ClientRequest;
import com.exim.client.repository.ContRepository;

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

    @Autowired
    private ContRepository contRepository;

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
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));
        return mapToResponse(client);
    }

    public List<ClientResponse> searchByName(String nume) {
        List<ClientResponse> results =  clientRepository.findByNumeContainingIgnoreCase(nume)
                .stream()
                .map(this::mapToResponse)
                .toList();
        if (results.isEmpty()){
            throw new ResourceNotFoundException("No client was not found!"); 
        }
        return results;
    }

    public List<ClientResponse> searchByStatus(Boolean status) {
		List<ClientResponse> results = clientRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .toList();
        if (results.isEmpty()){
            throw new ResourceNotFoundException("No client was not found!"); 
        }
        return results;
	}

    public DetaliiClientView getCompleteProfile(String codClient) {
        return detaliiClientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("The client's details were not found for codClient: " + codClient));
    }

    public List<DetaliiClientView> searchByTara(String tara) {
        List<DetaliiClientView> results = detaliiClientRepository.findByTaraIgnoreCase(tara);
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No clients were found in country:" + tara);
        }
        return results;
    }

    public List<DetaliiClientView> searchByOras(String oras) {
        List<DetaliiClientView> results = detaliiClientRepository.findByOrasContainingIgnoreCase(oras);
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No clients were found in city: " + oras);
        }
        return results;
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

    @Transactional
    public void deleteClientLogical(String codClient) {
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));

        if (Boolean.FALSE.equals(client.getStatus()))
            throw new IllegalStateException("The client is already inactive!");

        client.setStatus(false);
        clientRepository.save(client);

        List<Adresa> adrese = adresaRepository.findByIdClient(client.getIdClient());
        for (Adresa adresa : adrese) {
            adresa.setStatus(false);
            adresaRepository.save(adresa);
        }

        contactRepository.findByIdClient(client.getIdClient()).ifPresent(contact -> {
            contact.setStatus(false);
            contactRepository.save(contact);
        });

        List<Cont> conturi = contRepository.findByIdClient(client.getIdClient());
        for (Cont cont : conturi) {
            cont.setStareCont(false);
            contRepository.save(cont);
        }
    }

    @Transactional
    public ClientResponse updateClient(String codClient, UpdateClientRequest request) {
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));
        
        boolean isCurrentStatusFalse = Boolean.FALSE.equals(client.getStatus());
        boolean isCurrentStatusTrue = Boolean.TRUE.equals(client.getStatus());
        boolean isRequestStatusFalse = Boolean.FALSE.equals(request.getStatus());
        boolean isRequestStatusNull = request.getStatus() == null;
        boolean isRequestStatusTrue = Boolean.TRUE.equals(request.getStatus());
        
        if ((isCurrentStatusFalse && isRequestStatusFalse) || (isCurrentStatusFalse && isRequestStatusNull)){
            throw new IllegalStateException("The client is already inactive and cannot be updated unless activated again!");
        }

        if (isCurrentStatusTrue || (isCurrentStatusFalse && isRequestStatusTrue)){
            if (request.getNume() != null && !request.getNume().isBlank()) {
                client.setNume(request.getNume());
            }
            if (request.getPrenume() != null && !request.getPrenume().isBlank()) {
                client.setPrenume(request.getPrenume());
            }
        }
        if (request.getStatus() != null) {
            client.setStatus(request.getStatus());
        }

        Client updatedClient = clientRepository.save(client);
        return mapToResponse(updatedClient);
    }

    @Transactional
    public Adresa updateAdresa(String codClient, String tipAdresa, UpdateAdresaRequest request) {
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));

        Adresa adresa = adresaRepository.findByIdClientAndTipAdresa(client.getIdClient(), TipAdresa.valueOf(tipAdresa.toUpperCase()))
                .orElseThrow(() -> new ResourceNotFoundException("The address was not found!"));
        
        if (Boolean.FALSE.equals(client.getStatus()))
            throw new IllegalStateException("The client is inactive!");

        if (Boolean.FALSE.equals(adresa.getStatus()) || (Boolean.FALSE.equals(adresa.getStatus()) && Boolean.FALSE.equals(request.getStatus())))
            throw new IllegalStateException("The address is inactive and cannot be updated unless activated again!");

        if (Boolean.TRUE.equals(adresa.getStatus()) || (Boolean.FALSE.equals(adresa.getStatus()) && Boolean.TRUE.equals(request.getStatus())))
        {    
            if (request.getTara() != null && !request.getTara().isBlank()) {
                adresa.setTara(request.getTara());
            }
            if (request.getOras() != null && !request.getOras().isBlank()) {
                adresa.setOras(request.getOras());
            }
            if (request.getStrada() != null && !request.getStrada().isBlank()) {
                adresa.setStrada(request.getStrada());
            }
            if (request.getNr() != null) {
                adresa.setNumar(request.getNr());
            }
            if (request.getTipAdresa() != null && !request.getTipAdresa().isBlank()) {
                adresa.setTipAdresa(TipAdresa.valueOf(request.getTipAdresa().toUpperCase()));
            }
        }

        if (request.getStatus() != null) {
            adresa.setStatus(request.getStatus());
        }

        return adresaRepository.save(adresa);
    }

    @Transactional
    public Contact updateContact(String codClient, UpdateContactRequest request) {
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));

        Contact contact = contactRepository.findByIdClient(client.getIdClient())
                .orElseThrow(() -> new ResourceNotFoundException("The contact was not found!"));
        
        if (Boolean.FALSE.equals(client.getStatus())){
            throw new IllegalStateException("The client is inactive and cannot be updated!");
        }

        if (Boolean.FALSE.equals(contact.getStatus()) || (Boolean.FALSE.equals(contact.getStatus()) && Boolean.FALSE.equals(request.getStatus()))){
            throw new IllegalStateException("The contact is inactive and cannot be updated unless activated again!");
        }

        if (Boolean.TRUE.equals(contact.getStatus()) || (Boolean.FALSE.equals(contact.getStatus()) && Boolean.TRUE.equals(request.getStatus()))){
            if (request.getEmail() != null && !request.getEmail().isBlank()) {
                contact.setEmail(request.getEmail());
            }
            if (request.getTelMobil() != null && !request.getTelMobil().isBlank()) {
                contact.setTelMobil(request.getTelMobil());
            }
            if (request.getStatus() != null) {
                contact.setStatus(request.getStatus());
            }
        }

        return contactRepository.save(contact);
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
