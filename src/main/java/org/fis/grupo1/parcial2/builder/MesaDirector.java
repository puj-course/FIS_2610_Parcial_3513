package org.fis.grupo1.parcial2.builder;

import org.fis.grupo1.JuradoVotacion;
import org.fis.grupo1.Mesa;

import java.util.ArrayList;

public class MesaDirector {

    public Mesa buildMesa(int idMesa, ArrayList<String> votos, ArrayList<JuradoVotacion> jurados) {
        MesaBuilder builder = new MesaBuilder(idMesa, votos, jurados);
        builder.buildIdMesa();
        builder.buildVotos();
        builder.buildJurados();
        return builder.getResult();
    }
}