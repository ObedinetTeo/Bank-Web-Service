package com.exim.client.dto;

import java.time.LocalDate;

public class ContResponse {
    private String codClient;
    private String numeComplet; 
    private String tipContDescriere;
    private LocalDate dataDeschidere;
    private LocalDate dataInchidere;
    private Integer zileVechime; 
    private String statusDetaliat;

    public String getCodClient() {
        return codClient;
    }
    public void setCodClient(String codClient) {
        this.codClient = codClient;
    }
    public String getTipContDescriere() {
        return tipContDescriere;
    }
    public void setTipContDescriere(String tipContDescriere) {
        this.tipContDescriere = tipContDescriere;
    }
    public String getStatusDetaliat() {
        return statusDetaliat;
    }
    public void setStatusDetaliat(String statusDetaliat) {
        this.statusDetaliat = statusDetaliat;
    }
    public LocalDate getDataDeschidere() {
        return dataDeschidere;
    }
    public void setDataDeschidere(LocalDate dataDeschidere) {
        this.dataDeschidere = dataDeschidere;
    }
    public LocalDate getDataInchidere() {
        return dataInchidere;
    }
    public void setDataInchidere(LocalDate dataInchidere) {
        this.dataInchidere = dataInchidere;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public void setNumeComplet(String numeComplet) {
        this.numeComplet = numeComplet;
    }

    public Integer getZileVechime() {
        return zileVechime;
    }

    public void setZileVechime(Integer zileVechime) {
        this.zileVechime = zileVechime;
    }
}
