package com.exim.client.dto;

public class UpdateContactRequest {
    private String email;
    private String telMobil;
    private Boolean status;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelMobil() { return telMobil; }
    public void setTelMobil(String telMobil) { this.telMobil = telMobil; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
