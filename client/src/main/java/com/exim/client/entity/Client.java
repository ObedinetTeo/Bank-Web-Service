package com.exim.client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienti", schema = "exim")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", length = 10)
    private Long idClient;

    @Column(name = "cod_client", nullable = false, unique = true, length = 10)
    private String codClient;

    @Column(name = "nume", nullable = false, length = 30)
    private String nume;

    @Column(name = "prenume", nullable = false, length = 50)
    private String prenume;

    @Column(name = "cnp", nullable = false, unique = true, length = 13)
    private String cnp;

    @Column(name = "act_id", nullable = false, length = 50)
    private String actId;

    @Column(name = "status", nullable = false)
    private Boolean status;

    // --- Default constructor ---
    public Client() {
    }

    // --- Getters and Setters ---
    public Long getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getCodClient() {
        return this.codClient;
    }

    public void setCodClient(String codClient) {
        this.codClient = codClient;
    }

    public String getCnp() {
        return this.cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getActId() {
        return this.actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
