package org.fis.grupo5.Parcial2.entity;
public class Reclamacion {
    private int id;
    private String motivo;
    private String solicitante;
    private Acta acta;
    private String estado;

    public Reclamacion(int id, String motivo, String solicitante, Acta acta, String estado) {
        this.id = id;
        this.motivo = motivo;
        this.solicitante = solicitante;
        this.acta = acta;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }

    public Acta getActa() { return acta; }
    public void setActa(Acta acta) { this.acta = acta; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}