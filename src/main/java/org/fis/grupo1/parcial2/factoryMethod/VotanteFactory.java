package org.fis.grupo1.parcial2.factoryMethod;

public class VotanteFactory implements Factory{
    @Override
    public Persona create(String cedula, int mesa) {
        return new Votante(cedula);
    }
}
