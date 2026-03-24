package com.exim.client.entity;

import com.exim.client.model.TipAdresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adrese", schema = "exim")
public class Adresa {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresa", length = 10)
    private Long idAdresa;

    @Column(name = "id_client", nullable = false, unique = true, length = 10)
    private Long idClient;

    // @Column(name = "tara", nullable = false, length = 50)
    // private String tara;

    @Column(name = "oras", nullable = false, length = 50)
    private String oras;

    @Column(name = "strada", nullable = false, length = 50)
    private String strada;

    @Column(name = "nr", nullable = false, length = 10)
    private String numar;

    @Enumerated(EnumType.STRING)
    @Column(name = "tip_adresa", nullable = false, length = 100)
    private TipAdresa tipAdresa;

    @Column(name = "status", nullable = false)
    private Boolean status;

    // --- Default constructor ---
    public Adresa() {
    }

    // --- Getters and Setters ---
    public Long getIdAdresa() {
        return this.idAdresa;
    }

    public void setIdAdresa(Long idAdresa) {
        this.idAdresa = idAdresa;
    }

    public Long getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getOras() {
        return this.oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return this.strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNumar() {
        return this.numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public TipAdresa getTipAdresa() {
        return this.tipAdresa;
    }

    public void setTipAdresa(TipAdresa tipAdresa) {
        this.tipAdresa = tipAdresa;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
