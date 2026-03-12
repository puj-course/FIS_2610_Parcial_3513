package org.fis;

public class ProcesosElectoralesG4 {
    private String tipoEleccion;
    private String fecha;
    private String estado;

    public ProcesosElectoralesG4(String tipoEleccion, String fecha, String estado) {
        this.tipoEleccion = tipoEleccion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getTipoEleccion() {
        return tipoEleccion;
    }

    public void setTipoEleccion(String tipoEleccion) {
        this.tipoEleccion = tipoEleccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
