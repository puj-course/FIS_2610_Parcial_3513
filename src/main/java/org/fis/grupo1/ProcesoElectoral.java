package org.fis.grupo1;

public class ProcesoElectoral {
    private String tipo;
    private String fecha;
    private String estado;

    public ProcesoElectoral(String tipo, String fecha, String estado) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
