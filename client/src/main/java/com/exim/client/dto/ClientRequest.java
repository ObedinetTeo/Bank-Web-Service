package com.exim.client.dto;

public class ClientRequest {
    @NotBlank(message = "Numele este obligatoriu!")
    @Size(min = 2, max = 30, message = "Numele trebuie sa aiba intre 2 si 30 de caractere!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "Numele poate contine doar litere si cratime!")
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu!")
    @Size(min = 2, max = 50, message = "Prenumele trebuie sa aiba intre 2 si 50 de caractere!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "Prenumele poate contine doar litere si cratime!")
    private String prenume;

    @Pattern(regexp = "^[0-9]{13}$", message = "CNP-ul trebuie sa aiba exact 13 cifre!")
    private String cnp;

    @NotBlank(message = "Actul de identitate este obligatoriu!")
    @Size(min = 2, max = 50, message = "Actul de identitate trebuie sa aiba intre 2 si 50 de caractere!")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Actul de identitate poate contine doar numere si litere!")
    private String actId;

    @Valid
    @NotNull(message = "Datele adresei sunt obligatorii!")
    private AdresaRequest adresa;

    @Valid
    @NotNull(message = "Datele de contact sunt obligatorii!")
    private ContactRequest contact;

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }
    public String getCnp() { return cnp; }
    public void setCnp(String cnp) { this.cnp = cnp; }
    public String getActId() { return actId; }
    public void setActId(String actId) { this.actId = actId; }

    public AdresaRequest getAdresa() { return adresa; }
    public void setAdresa(AdresaRequest adresa) { this.adresa = adresa; }
    public ContactRequest getContact() { return contact; }
    public void setContact(ContactRequest contact) { this.contact = contact; }
    
}
