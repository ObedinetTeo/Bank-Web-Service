package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class UpdateContactRequest {
    @Pattern(regexp = "^[0-9]{10,15}$", message = "The phone number must have between 10 and 15 digits!")
    @NotBlank(message = "The phone number is mandatory!")
    private String telefon;

    @NotBlank(message = "The email is mandatory!")
    private String email;
    
    private Boolean status;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelMobil() { return telefon; }
    public void setTelMobil(String telMobil) { this.telefon = telMobil; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
