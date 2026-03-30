package com.exim.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exim.client.dto.ContResponse;
import com.exim.client.entity.SituatieConturiView;
import com.exim.client.repository.SituatieConturiRepository;

@Service
public class ContService {
    @Autowired
    private SituatieConturiRepository situatieConturiRepository;

    public List<ContResponse> getConturiByCodClient(String codClient) {
        return situatieConturiRepository.findByCodClient(codClient)
                .stream()
                .map(this::mapToResponse)
                .toList();
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
