package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_client_dupa_cod", schema = "exim")
public class ClientCodView {
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

    @Column(name = "status")
    private Boolean status;

    // --- Default constructor ---
    public ClientCodView() {
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

    public Boolean getStatus() {
        return status;
    }
}
