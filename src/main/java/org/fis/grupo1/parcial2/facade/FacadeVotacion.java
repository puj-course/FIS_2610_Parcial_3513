package org.fis.grupo1.parcial2.facade;

import org.fis.grupo1.Municipio;

import java.util.List;

public class FacadeVotacion {

    private final JuradoVotacion juradoVotacion;
    private final Mesa mesa;
    private final Municipio municipio;


    public FacadeVotacion(JuradoVotacion juradoVotacion, Mesa mesa, Municipio municipio) {
        this.juradoVotacion = juradoVotacion;
        this.mesa = mesa;
        this.municipio = municipio;
    }

    Mesa investigarMesaVotacion(String cedula){
        //se busca al jurado y se devuelve la mesa en la q le toca
        return null;
    }

    Municipio investigarMunicipio(String cedula){
        //se busca al jurado y e devuelve en el municipio donde le toca
        return null;
    }

    List<JuradoVotacion> juradosEnMesa(String idMesa){
        //se busca la mesa y se devuelve los jurados de esa mesa
        return null;
    }


}
