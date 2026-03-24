package com.exim.client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import com.exim.client.model.TipCont;

@Entity
@Table(name = "conturi", schema = "exim")
public class Cont {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cont", length = 10)
    private Long idCont;

    @Column(name = "id_client", nullable = false, unique = true, length = 10)
    private Long idClient;

    @Enumerated(EnumType.STRING)
    @Column(name = "tip_cont", nullable = false, length = 10)
    private TipCont tipCont;

    @Column(name = "stare_cont", nullable = false)
    private Boolean stareCont;

    @Column(name = "data_deschidere", nullable = false)
    private LocalDate dataDeschidere;

    @Column(name = "data_inchidere")
    private LocalDate dataInchidere;

    // --- Default constructor ---
    public Cont() {
    }

    // --- Getters and Setters ---
    public Long getIdCont() {
        return this.idCont;
    }

    public void setIdCont(Long idCont) {
        this.idCont = idCont;
    }

    public Long getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public TipCont getTipCont() {
        return this.tipCont;
    }

    public void setTipCont(TipCont tipCont) {
        this.tipCont = tipCont;
    }

    public Boolean getStareCont() {
        return this.stareCont;
    }

    public void setStareCont(Boolean stareCont) {
        this.stareCont = stareCont;
    }

    public LocalDate getDataDeschidere() {
        return this.dataDeschidere;
    }

    public void setDataDeschidere(LocalDate dataDeschidere) {
        this.dataDeschidere = dataDeschidere;
    }

    public LocalDate getDataInchidere() {
        return this.dataInchidere;
    }

    public void setDataInchidere(LocalDate dataInchidere) {
        this.dataInchidere = dataInchidere;
    }

}

