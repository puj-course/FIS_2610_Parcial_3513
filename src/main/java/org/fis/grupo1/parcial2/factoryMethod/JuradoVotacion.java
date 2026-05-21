package org.fis.grupo1.parcial2.factoryMethod;

public class JuradoVotacion extends Persona{
    int mesaAsociada;

    public JuradoVotacion(String cedula, int mesaAsociada) {
        super(cedula);
        this.mesaAsociada = mesaAsociada;
    }

    public int getMesaAsociada() {
        return mesaAsociada;
    }

    public void setMesaAsociada(int mesaAsociada) {
        this.mesaAsociada = mesaAsociada;
    }
}
