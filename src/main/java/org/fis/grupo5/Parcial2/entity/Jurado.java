package org.fis.grupo5.Parcial2.entity;
public class Jurado {
    private int id;
    private String nombre;
    private String cedula;
    private String funcion;
    private Mesa mesa;

    public Jurado(int id, String nombre, String cedula, String funcion, Mesa mesa) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.funcion = funcion;
        this.mesa = mesa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getFuncion() { return funcion; }
    public void setFuncion(String funcion) { this.funcion = funcion; }

    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }
}