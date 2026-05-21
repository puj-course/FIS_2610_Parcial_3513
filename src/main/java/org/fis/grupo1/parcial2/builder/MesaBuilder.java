package org.fis.grupo1.parcial2.builder;

import org.fis.grupo1.JuradoVotacion;
import org.fis.grupo1.Mesa;

import java.util.ArrayList;

public class MesaBuilder implements MesaBuilderInterface {

    private int idMesa;
    private ArrayList<String> votos;
    private ArrayList<JuradoVotacion> jurados;
    private Mesa mesa;

    public MesaBuilder(int idMesa, ArrayList<String> votos, ArrayList<JuradoVotacion> jurados) {
        this.idMesa = idMesa;
        this.votos = votos;
        this.jurados = jurados;
        this.mesa = new Mesa(new ArrayList<>(), new ArrayList<>(), 0);
    }

    @Override
    public void buildIdMesa() {
        mesa.setIdMesa(idMesa);
    }

    @Override
    public void buildVotos() {
        mesa.setVotos(votos);
    }

    @Override
    public void buildJurados() {
        mesa.setJurados(jurados);
    }

    @Override
    public Mesa getResult() {
        return mesa;
    }
}