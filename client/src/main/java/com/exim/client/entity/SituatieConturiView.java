package com.exim.client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Immutable
@Table(name = "v_situatie_conturi", schema = "exim")
public class SituatieConturiView {
    @Id
    @Column(name = "id_cont")
    @JsonIgnore
    private Long idCont;

    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume_complet")
    private String numeComplet; 

    @Column(name = "tip_cont_descriere")
    private String tipContDescriere;

    @Column(name = "data_deschidere")
    private LocalDate dataDeschidere;

    @Column(name = "data_inchidere")
    private LocalDate dataInchidere;

    @Column(name = "zile_vechime")
    private Integer zileVechime; 

    @Column(name = "status_detaliat")
    private String statusDetaliat;

    // --- Default constructor ---
    public SituatieConturiView() {
    }

    // --- Getters ---
    public Long getIdCont() {
        return idCont;
    }

    public String getCodClient() {
        return codClient;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public String getTipContDescriere() {
        return tipContDescriere;
    }

    public LocalDate getDataDeschidere() {
        return dataDeschidere;
    }

    public LocalDate getDataInchidere() {
        return dataInchidere;
    }

    public Integer getZileVechime() {
        return zileVechime;
    }

    public String getStatusDetaliat() {
        return statusDetaliat;
    }
}
