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
        List<ContResponse> results = situatieConturiRepository.findByCodClient(codClient)
                .stream()
                .map(this::mapToResponse)
                .toList();
        if (results.isEmpty())
        {
            throw new ResourceNotFoundException("No account was found for this client!");
        }
        return results;
    }

    public List<ContResponse> getConturiByTipContDescriere(String tipContDescriere) {
        List<ContResponse> results = situatieConturiRepository.findByTipContDescriereIgnoreCase(tipContDescriere)
                .stream()
                .map(this::mapToResponse)
                .toList();
        if (results.isEmpty()){
            throw new ResourceNotFoundException("No account was found for this type!");
        }
        return results;
    }

    @Transactional
    public Cont deschidereCont(DeschidereContRequest request){
        Client client = clientRepository.findByCodClient(request.getCodClient())
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));

        Cont contNou = new Cont();
        contNou.setIdClient(client.getIdClient());
        contNou.setTipCont(TipCont.fromString(request.getTipCont()));
        contNou.setStareCont(true);
        contNou.setDataDeschidere(LocalDate.now());
        contNou.setDataInchidere(null);

        return contRepository.save(contNou);
    }

    @Transactional
    public ContResponse inchidereCont(String codClient, String tipCont){
        Client client = clientRepository.findByCodClient(codClient)
                .orElseThrow(() -> new ResourceNotFoundException("The client was not found!"));

        TipCont tipContEnum = TipCont.fromString(tipCont);
        List<Cont> conts = contRepository.findByIdClientAndTipCont(client.getIdClient(), tipContEnum);
        if (conts.isEmpty()) {
            throw new ResourceNotFoundException("The account was not found!");
        }
        Cont cont = conts.get(0);

        if (cont.getStareCont() == false) {
            throw new IllegalStateException("The account is already closed!");
        }

        cont.setStareCont(false);
        cont.setDataInchidere(LocalDate.now());
        contRepository.save(cont);

        return mapToResponse(situatieConturiRepository.findByCodClient(codClient)
                .stream()
                .filter(c -> c.getTipContDescriere().equalsIgnoreCase(tipContEnum.getDenumire()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("The account's situation was not found!")));
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
