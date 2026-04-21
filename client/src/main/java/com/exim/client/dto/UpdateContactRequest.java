package com.exim.client.dto;

public class UpdateContactRequest {
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Numariul de telefon trebuie sa aiba inre 10 si 15 cifre!")
    @NotBlank(message = "Telefonul nu poate fi gol!")
    private String telefon;

    @NotBlank(message = "Email-ul nu poate fi gol!")
    private String email;
    
    private Boolean status;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelMobil() { return telMobil; }
    public void setTelMobil(String telMobil) { this.telMobil = telMobil; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
