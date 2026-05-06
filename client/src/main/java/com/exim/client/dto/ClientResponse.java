package com.exim.client.dto;

public class ClientResponse {
    private String codClient;
    private String cnp;
    private String actId;
    private String nume;
    private String prenume;
    private Boolean status;

    public String getCodClient() { return codClient; }
    public void setCodClient(String codClient) { this.codClient = codClient; }
    public String getCnp() { return cnp; }
    public void setCnp(String cnp) { this.cnp = cnp; }
    public String getActId() { return actId; }
    public void setActId(String actId) { this.actId = actId; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
