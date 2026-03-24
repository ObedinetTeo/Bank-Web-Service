package com.exim.client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_situatie_conturi", schema = "exim")
public class SituatieConturiView {
    @Id
    @Column(name = "id_cont")
    private Long idCont;

    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume_complet")
    private String numeComplet; 

    @Column(name = "tip_cont_descriere")
    private String tipContDescriere;

    @Column(name = "stare_cont")
    private Boolean stareCont;

    @Column(name = "data_deschidere")
    private LocalDate dataDeschidere;

    @Column(name = "data_inchidere")
    private LocalDate dataInchidere;

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
    public Boolean getStareCont() {
        return stareCont;
    }

    public LocalDate getDataDeschidere() {
        return dataDeschidere;
    }

    public LocalDate getDataInchidere() {
        return dataInchidere;
    }
}
