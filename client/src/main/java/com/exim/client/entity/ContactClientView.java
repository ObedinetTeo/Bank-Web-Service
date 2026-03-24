package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_contact_client", schema = "exim")
public class ContactClientView {
@Id
    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_mobil")
    private String telMobil;

    // --- Default constructor ---
    public ContactClientView() {
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

    public String getEmail() {
        return email;
    }

    public String getTelMobil() {
        return telMobil;
    }
}
