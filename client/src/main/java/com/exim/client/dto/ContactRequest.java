package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class ContactRequest {
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Numariul de telefon trebuie sa aiba inre 10 si 15 cifre!")
    @NotBlank(message = "Telefonul nu poate fi gol!")
    private String telefon;

    @NotBlank(message = "Email-ul nu poate fi gol!")
    private String email;

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
