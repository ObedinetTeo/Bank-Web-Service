package com.exim.client.model;

public enum TipCont {
    CA("Card"),
    CR("Credit"),
    D("Depozit");

    public final String denumire;

    TipCont(String denumire){
        this.denumire = denumire;
    }

    public String getDenumire(){
        return this.denumire;
    }
}
