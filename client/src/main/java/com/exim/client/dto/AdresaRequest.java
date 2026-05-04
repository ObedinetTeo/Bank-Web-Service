package com.exim.client.dto;
import jakarta.validation.constraints.*;

public class AdresaRequest {
    @NotBlank(message = "Tara este obligatorie!")
    private String tara;

    @NotBlank(message = "Orasul este obligatoriu!")
    private String oras;

    @NotBlank(message = "Strada este obligatorie!")
    private String strada;

    @NotNull(message = "Numarul este obligatoriu!")
    private Integer nr;

    @NotBlank(message = "Tipul de adresa este obligatoriu!")
    private String tipAdresa;

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
}
