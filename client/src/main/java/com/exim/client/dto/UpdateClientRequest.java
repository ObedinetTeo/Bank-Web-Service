package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class UpdateClientRequest {
    @NotBlank(message = "Numele este obligatoriu!")
    @Size(min = 2, max = 30, message = "Numele trebuie sa aiba intre 2 si 30 de caractere!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "Numele poate contine doar litere si cratime!")
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu!")
    @Size(min = 2, max = 50, message = "Prenumele trebuie sa aiba intre 2 si 50 de caractere!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "Prenumele poate contine doar litere si cratime!")
    private String prenume;
    
    private Boolean status;

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
