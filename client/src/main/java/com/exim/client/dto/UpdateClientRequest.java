package com.exim.client.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateClientRequest {

    @NotBlank(message = "Telefonul este obligatoriu")
    @Pattern(regexp = "^[0-9+ ]{8,20}$", message = "Telefon invalid")
    private String telefon;

    @NotBlank(message = "Emailul este obligatoriu")
    @Email(message = "Email invalid")
    @Size(max = 100, message = "Email prea lung")
    private String email;

    @NotBlank(message = "Adresa este obligatorie")
    private String adresa;

    @NotBlank(message = "Statusul este obligatoriu")
    @Pattern(regexp = "^(ACTIV|INACTIV|BLOCAT)$", message = "Status invalid")
    private String status;

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
