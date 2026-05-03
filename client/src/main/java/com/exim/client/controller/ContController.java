package com.exim.client.controller;

import com.exim.client.service.ContService;
import com.exim.client.dto.ContResponse;
import com.exim.client.dto.DeschidereContRequest;
import com.exim.client.entity.Cont;
import com.exim.client.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;




@RestController
@RequestMapping("/api/accounts")
public class ContController {
    @Autowired
    private ContService contService;

    public ContController(ContService contService) {
        this.contService = contService;
    }

    @GetMapping("/byCodClient/{codClient}")
    public List<ContResponse> searchByCodClient(@PathVariable String codClient) {
        List<ContResponse> results = contService.getConturiByCodClient(codClient);
        if (results.isEmpty())
        {
            throw new ResourceNotFoundException("No active accounts were found!");
        }
        return results;
    }
    
    @GetMapping("/byTipCont/{tipContDescriere}")
    public List<ContResponse> searchByTipCont(@PathVariable String tipContDescriere) {
        List<ContResponse> results = contService.getConturiByTipContDescriere(tipContDescriere);
        if (results.isEmpty())
        {
            throw new ResourceNotFoundException("No active accounts were found for this account type!");
        }
        return results;
    }

    @PostMapping("/open")
    public Cont openCont(@RequestBody DeschidereContRequest request) {
        return contService.deschidereCont(request);
    }

    @PutMapping("/close/{codClient}/{tipCont}")
    public ResponseEntity<ContResponse> inchidereCont(@PathVariable String codClient, @PathVariable String tipCont) {
        ContResponse response = contService.inchidereCont(codClient, tipCont);
        return ResponseEntity.ok(response);
    }
}
