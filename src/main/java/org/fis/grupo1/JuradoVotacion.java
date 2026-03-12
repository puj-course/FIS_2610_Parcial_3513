package org.fis.grupo1;

public class JuradoVotacion {

    String cedula;
    String nombre;
    String funcion;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public JuradoVotacion(String cedula, String nombre, String funcion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.funcion = funcion;
    }
}
