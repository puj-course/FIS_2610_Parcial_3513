package org.fis.grupo1.parcial2.factoryMethod;

public class JuradoFactory implements Factory{
    @Override
    public Persona create(String cedula, int mesa) {
        return new JuradoVotacion(cedula, mesa);
    }
}
