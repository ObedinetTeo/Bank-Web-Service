package com.exim.client.model;

public enum TipAdresa {
    D("Adresa de domiciliu"),
    R("Adresa de resedinta"),
    C("Adresa de corespondenta");

    private final String denumire;

    TipAdresa(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return this.denumire;
    }

}
