package com.exim.client.dto;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


public class ClientRequest {
    @NotBlank(message = "The last name is mandatory!")
    @Size(min = 2, max = 30, message = "The last name must have between 2 and 30 characters!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "The last name can only contain letters and hyphens!")
    private String nume;

    @NotBlank(message = "The first name is mandatory!")
    @Size(min = 2, max = 50, message = "The first name must have between 2 and 50 characters!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "The first name can only contain letters and hyphens!")
    private String prenume;

    @Pattern(regexp = "^[0-9]{13}$", message = "The CNP must have exactly 13 digits!")
    private String cnp;

    @NotBlank(message = "The identity document is mandatory!")
    @Size(min = 2, max = 50, message = "The identity document must have between 2 and 50 characters!")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "The identity document can only contain letters and numbers!")
    private String actId;

    @Valid
    @NotNull(message = "The address details are mandatory!")
    private AdresaRequest adresa;

    @Valid
    @NotNull(message = "The contact details are mandatory!")
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
