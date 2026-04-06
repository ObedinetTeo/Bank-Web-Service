package com.exim.client.dto;

public class ClientRequest {
    private String nume;
    private String prenume;
    private String cnp;
    private String actId;

    private AdresaRequest adresa;
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
