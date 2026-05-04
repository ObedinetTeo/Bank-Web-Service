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

    public static TipCont fromString(String tipCont) {
        if (tipCont == null) {
            throw new IllegalArgumentException("The account type must be provided!");
        }
        String normalized = tipCont.trim();
        for (TipCont tip : TipCont.values()) {
            if (tip.name().equalsIgnoreCase(normalized) || tip.denumire.equalsIgnoreCase(normalized)) {
                return tip;
            }
        }
        throw new IllegalArgumentException("Unknown account type: " + tipCont);
    }
}
