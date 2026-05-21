package org.fis.grupo5.Parcial2.entity;
public class Incidente {
    private int id;
    private String descripcion;
    private String tipo;
    private String estado;
    private Mesa mesa;

    public Incidente(int id, String descripcion, String tipo, String estado, Mesa mesa) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.mesa = mesa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }
}