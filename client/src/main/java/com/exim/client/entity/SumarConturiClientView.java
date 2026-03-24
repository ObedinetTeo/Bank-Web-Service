package com.exim.client.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "v_sumar_conturi_client", schema = "exim")
public class SumarConturiClientView {
@Id
    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "nume_complet")
    private String numeComplet;

    @Column(name = "numar_total_conturi")
    private Long numarTotalConturi;

    @Column(name = "numar_conturi_card")
    private Long numarConturiCard;

    @Column(name = "numar_depozite")
    private Long numarDepozite;

    @Column(name = "numar_credite")
    private Long numarCredite;

    // --- Default constructor ---
    public SumarConturiClientView() {
    }

    // --- Getters ---
    public String getCodClient() {
        return codClient;
    }


    public String getNumeComplet() {
        return numeComplet;
    }

    public Long getNumarTotalConturi() {
        return numarTotalConturi;
    }

    public Long getNumarConturiCard() {
        return numarConturiCard;
    }

    public Long getNumarDepozite() {
        return numarDepozite;
    }
    public Long getNumarCredite() {
        return numarCredite;
    }
}
