package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import com.exim.client.model.TipAdresa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_detalii_client", schema = "exim")
public class DetaliiClientView {
    @Id
    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "cnp")
    private String cnp;

    @Column(name = "act_id")
    private String actId;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_mobil")
    private String telMobil;

    @Column(name = "tara")
    private String tara;

    @Column(name = "oras")
    private String oras;

    @Column(name = "strada")
    private String strada;

    @Column(name = "numar_adresa")
    private Long numarAdresa; 

    @Enumerated(EnumType.STRING)
    @Column(name = "tip_adresa")
    private TipAdresa tipAdresa;

    // --- Default Constructor ---
    public DetaliiClientView() {
    }

    // --- Getters ---
    public String getCodClient() {
        return codClient;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public String getActId() {
        return actId;
    }

    public String getEmail() {
        return email;
    }

    public String getTelMobil() {
        return telMobil;
    }

    public String getOras() {
        return oras;
    }

    public String getStrada() {
        return strada;
    }

    public Long getNumarAdresa() {
        return numarAdresa;
    }

    public TipAdresa getTipAdresa() {
        return tipAdresa;
    }
}
