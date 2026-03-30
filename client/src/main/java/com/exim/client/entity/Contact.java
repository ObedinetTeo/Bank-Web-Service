package com.exim.client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacte", schema = "exim")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact", length = 10)
    private Long idContact;

    @Column(name = "id_client", nullable = false, unique = true, length = 10)
    private Long idClient;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "tel_mobil", nullable = false, length = 25, unique = true)
    private String telMobil;

    @Column(name = "status", nullable = false)
    private Boolean status;

    // --- Default constructor ---
    public Contact() {
    }

    // --- Getters and Setters ---
    public Long getIdContact() {
        return this.idContact;
    }

    public Long getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelMobil() {
        return this.telMobil;
    }

    public void setTelMobil(String telMobil) {
        this.telMobil = telMobil;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
