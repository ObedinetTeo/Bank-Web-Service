package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import com.exim.client.model.TipCont;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_clienti_per_tip_cont", schema = "exim")
public class ClientiPerTipContView {
    @Id
    @Column(name = "id_cont")
    @JsonIgnore
    private Long idCont;

    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Enumerated(EnumType.STRING)
    @Column(name = "tip_cont")
    private TipCont tipCont;

    @Column(name = "denumire_cont")
    private String denumireCont;

    // --- Default constructor ---
    public ClientiPerTipContView() {
    }

    // --- Getters ---
    public Long getIdCont() {
        return idCont;
    }

    public String getCodClient() {
        return codClient;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public TipCont getTipCont() {
        return tipCont;
    }

    public String getDenumireCont() {
        return denumireCont;
    }
}
