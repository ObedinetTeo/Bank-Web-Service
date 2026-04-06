package com.exim.client.controller;

import com.exim.client.service.ContService;
import com.exim.client.dto.ContResponse;
import com.exim.client.dto.DeschidereContRequest;
import com.exim.client.entity.Cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@RestController
@RequestMapping("/api/conturi")
public class ContController {
    @Autowired
    private ContService contService;

    public ContController(ContService contService) {
        this.contService = contService;
    }

    @GetMapping("/byCodClient/{codClient}")
    public List<ContResponse> searchByCodClient(@PathVariable String codClient) {
        return contService.getConturiByCodClient(codClient);
    }
    
    @GetMapping("/byTipCont/{tipContDescriere}")
    public List<ContResponse> searchByTipCont(@PathVariable String tipContDescriere) {
        return contService.getConturiByTipContDescriere(tipContDescriere);
    }

    @PostMapping("/open")
    public Cont openCont(@RequestBody DeschidereContRequest request) {
        return contService.deschidereCont(request);
    }
    
    @PostMapping("/close")
    public Cont postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
