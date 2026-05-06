package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_clienti_adrese_multiple", schema = "exim")
public class ClientiAdreseMultipleView {
    @Id
    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume")
    private String nume;

    @Column(name = "numar_adrese")
    private Long numarAdrese; 

    // --- Default constructor ---
    public ClientiAdreseMultipleView() {
    }

    // --- Getters ---
    public String getCodClient() {
        return codClient;
    }

    public String getNume() {
        return nume;
    }

    public Long getNumarAdrese() {
        return numarAdrese;
    }
}
