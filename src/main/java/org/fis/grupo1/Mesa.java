package org.fis.grupo1;

import java.util.ArrayList;

public class Mesa {
    ArrayList <String> votos;
    ArrayList <JuradoVotacion> jurados;
    int idMesa;

    public Mesa(ArrayList<String> votos, ArrayList<JuradoVotacion> jurados, int idMesa) {
        this.votos = votos;
        this.jurados = jurados;
        this.idMesa = idMesa;
    }

    public ArrayList<String> getVotos() {
        return votos;
    }

    public void setVotos(ArrayList<String> votos) {
        this.votos = votos;
    }

    public ArrayList<JuradoVotacion> getJurados() {
        return jurados;
    }

    public void setJurados(ArrayList<JuradoVotacion> jurados) {
        this.jurados = jurados;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
}




