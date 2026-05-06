package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class UpdateClientRequest {
    @NotBlank(message = "The last name is mandatory!")
    @Size(min = 2, max = 30, message = "The last name must have between 2 and 30 characters!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "The last name can only contain letters and hyphens!")
    private String nume;

    @NotBlank(message = "The first name is mandatory!")
    @Size(min = 2, max = 50, message = "The first name must have between 2 and 50 characters!")
    @Pattern(regexp = "^[a-zA-Z\\s-]+$", message = "The first name can only contain letters and hyphens!")
    private String prenume;
    
    private Boolean status;

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
