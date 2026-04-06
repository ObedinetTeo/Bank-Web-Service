package com.exim.client.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exim.client.dto.ContResponse;
import com.exim.client.dto.DeschidereContRequest;
import com.exim.client.entity.Client;
import com.exim.client.entity.Cont;
import com.exim.client.entity.SituatieConturiView;
import com.exim.client.exception.ResourceNotFoundException;
import com.exim.client.model.TipCont;
import com.exim.client.repository.ClientRepository;
import com.exim.client.repository.ContRepository;
import com.exim.client.repository.SituatieConturiRepository;

import jakarta.transaction.Transactional;

@Service
public class ContService {
    @Autowired
    private SituatieConturiRepository situatieConturiRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContRepository contRepository;

    public List<ContResponse> getConturiByCodClient(String codClient) {
        return situatieConturiRepository.findByCodClient(codClient)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<ContResponse> getConturiByTipContDescriere(String tipContDescriere) {
        return situatieConturiRepository.findByTipContDescriereIgnoreCase(tipContDescriere)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional
    public Cont deschidereCont(DeschidereContRequest request){
        Client client = clientRepository.findByCodClient(request.getCodClient())
                .orElseThrow(() -> new ResourceNotFoundException("Clientul nu a fost gasit"));

        Cont contNou = new Cont();
        contNou.setIdClient(client.getIdClient());
        contNou.setTipCont(TipCont.valueOf(request.getTipCont().toUpperCase()));
        contNou.setStareCont(true);
        contNou.setDataDeschidere(LocalDate.now());
        contNou.setDataInchidere(null);

        return contRepository.save(contNou);
    }

    private ContResponse mapToResponse(SituatieConturiView view){
        ContResponse response = new ContResponse();
        response.setCodClient(view.getCodClient());
        response.setTipContDescriere(view.getTipContDescriere());
        response.setStatusDetaliat(view.getStatusDetaliat());
        response.setDataDeschidere(view.getDataDeschidere());
        response.setDataInchidere(view.getDataInchidere());
        response.setZileVechime(view.getZileVechime());
        response.setNumeComplet(view.getNumeComplet());
        return response;
    }
}
