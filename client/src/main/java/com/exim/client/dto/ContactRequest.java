package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class ContactRequest {
    @Pattern(regexp = "^[0-9]{10,15}$", message = "The phone number must have between 10 and 15 digits!")
    @NotBlank(message = "The phone number is mandatory!")
    private String telefon;

    @NotBlank(message = "The email is mandatory!")
    private String email;

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
