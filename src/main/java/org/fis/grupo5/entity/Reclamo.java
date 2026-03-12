package org.fis.grupo5.entity;
import java.time.LocalDateTime;

public class Reclamo {

    private int idReclamo;
    private String tipo;              // Tipo de reclamo: "Reclamacion" o "Incidente"
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private String estado;            //Estado en el que se encuentra el reclamo: Pendiente, En revisión, Resuelto
    
    private int idMesa;
    private int idPuestoVotacion;
    
    private String nombrePartido;
    private String nombreTestigo;

    public int getIdReclamo() {
        return idReclamo;
    }
    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getIdMesa() {
        return idMesa;
    }
    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    public int getIdPuestoVotacion() {
        return idPuestoVotacion;
    }
    public void setIdPuestoVotacion(int idPuestoVotacion) {
        this.idPuestoVotacion = idPuestoVotacion;
    }
    public String getNombrePartido() {
        return nombrePartido;
    }
    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }
    public String getNombreTestigo() {
        return nombreTestigo;
    }
    public void setNombreTestigo(String nombreTestigo) {
        this.nombreTestigo = nombreTestigo;
    }
    
    public Reclamo(int idReclamo, String tipo, String descripcion, LocalDateTime fechaRegistro, String estado,
            int idMesa, int idPuestoVotacion, String nombrePartido, String nombreTestigo) {
        this.idReclamo = idReclamo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.idMesa = idMesa;
        this.idPuestoVotacion = idPuestoVotacion;
        this.nombrePartido = nombrePartido;
        this.nombreTestigo = nombreTestigo;
    }
    
    @Override
    public String toString() {
        return "Reclamo [idReclamo=" + idReclamo + ", tipo=" + tipo + ", descripcion=" + descripcion
                + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", idMesa=" + idMesa
                + ", idPuestoVotacion=" + idPuestoVotacion + ", nombrePartido=" + nombrePartido + ", nombreTestigo="
                + nombreTestigo + "]";
    }
 
}