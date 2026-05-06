package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class UpdateAdresaRequest {
   @NotBlank(message = "The country is mandatory!")
    private String tara;

    @NotBlank(message = "The city is mandatory!")
    private String oras;

    @NotBlank(message = "The street is mandatory!")
    private String strada;

    @NotNull(message = "The number is mandatory!")
    private Integer nr;

    @NotBlank(message = "The type of address is mandatory!")
    private String tipAdresa;
    
    private Boolean status;

    public String getTara() { return tara; }
    public void setTara(String tara) { this.tara = tara; }
    public String getOras() { return oras; }
    public void setOras(String oras) { this.oras = oras; }
    public String getStrada() { return strada; }
    public void setStrada(String strada) { this.strada = strada; }
    public Integer getNr() { return nr; }
    public void setNr(Integer nr) { this.nr = nr; }
    public String getTipAdresa() { return tipAdresa; }
    public void setTipAdresa(String tipAdresa) { this.tipAdresa = tipAdresa; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
