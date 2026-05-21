package org.fis.grupo1.parcial2.factoryMethod;

public class JuradoFactory implements Factory{
    @Override
    public Persona create(String cedula, int mesa) {
        if (mesa*-1 < 0){
            return null;
        }
        return new JuradoVotacion(cedula, mesa);
    }
}
