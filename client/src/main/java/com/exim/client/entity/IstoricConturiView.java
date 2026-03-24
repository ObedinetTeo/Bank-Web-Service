package com.exim.client.entity;

import com.exim.client.model.TipCont;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_istoric_conturi", schema = "exim")
public class IstoricConturiView {
    @Id
    @Column(name = "id_cont")
    @JsonIgnore // Îl folosim doar intern pentru JPA
    private Long idCont;

    @Column(name = "cod_client")
    private String codClient;

    @Enumerated(EnumType.STRING)
    @Column(name = "tip_cont")
    private TipCont tipCont;

    @Column(name = "data_deschidere")
    private LocalDate dataDeschidere;

    @Column(name = "zile_vechime")
    private Integer zileVechime; // Postgres 'integer' se mapeaza pe 'Integer' in Java

    @Column(name = "status_detaliat")
    private String statusDetaliat;

    // --- Default constructor ---
    public IstoricConturiView() {
    }

    // --- Getters ---
    public Long getIdCont() {
        return idCont;
    }

    public String getCodClient() {
        return codClient;
    }

    public TipCont getTipCont() {
        return tipCont;
    }

    public LocalDate getDataDeschidere() {
        return dataDeschidere;
    }

    public Integer getZileVechime() {
        return zileVechime;
    }

    public String getStatusDetaliat() {
        return statusDetaliat;
    }
}
