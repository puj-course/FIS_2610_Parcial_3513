package org.fis.grupo1.parcial2.factoryMethod;

public abstract class Persona {
    String cedula;

    public Persona(String cedula) {
        this.cedula = cedula;;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}

