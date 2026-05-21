package org.fis.grupo1.parcial2.testsGrupo1;

import org.fis.grupo1.parcial2.factoryMethod.JuradoFactory;
import org.fis.grupo1.parcial2.factoryMethod.JuradoVotacion;
import org.fis.grupo1.parcial2.factoryMethod.Votante;
import org.fis.grupo1.parcial2.factoryMethod.VotanteFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTests {
    VotanteFactory votanteFactory;
    JuradoFactory juradoFactory;

    @Test
    //Normal
    void createVotante(){
        Votante votante = (Votante) votanteFactory.create("1025", 0);
        assertNotNull(votante);
        assertEquals("1025", votante.getCedula());

        System.out.println("Prueba normal: Creación votante");
        System.out.println("Cedula: "+votante.getCedula());
    }

    @Test
    //Normal
    void createJurado(){
        JuradoVotacion jurado = (JuradoVotacion) juradoFactory.create("1026", 36);
        assertNotNull(jurado);
        assertEquals("1025", jurado.getCedula());

        System.out.println("Prueba normal: Creación jurado");
        System.out.println("Cedula: "+jurado.getCedula());
        System.out.println("Mesa asignada: "+jurado.getMesaAsociada());
    }
}
