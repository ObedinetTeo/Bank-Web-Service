package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_adresa_client", schema = "exim")
public class AdresaClientView {
    @Id
    @Column(name = "id_adresa")
    @JsonIgnore
    private Long idAdresa;

    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "oras")
    private String oras;

    @Column(name = "strada")
    private String strada;

    @Column(name = "nr")
    private int nr; 

    @Column(name = "tip_adresa")
    private String tipAdresa; 

    @Column(name = "adresa_activa")
    private Boolean adresaActiva;

    // --- Default constructor ---
    public AdresaClientView() {
    }

    // --- Getters ---
    public Long getIdAdresa() {
        return idAdresa;
    }

    public String getCodClient() {
        return codClient;
    }

    public String getOras() {
        return oras;
    }

    public String getStrada() {
        return strada;
    }

    public int getNr() {
        return nr;
    }

    public String getTipAdresa() {
        return tipAdresa;
    }

    public Boolean getAdresaActiva() {
        return adresaActiva;
    }
}
