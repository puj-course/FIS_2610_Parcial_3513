package org.fis.grupo3;
import java.util.*;

public class ProcesoElectoral {
    private int id;
    private String tipoEleccion;
    private List<PustosVotacion> pustosVotacion;
    private Mesas mesas;
    private Jurado jurado;
    private PartidoPoliticos partidoPoliticos;
    private Candidatos candidatos;
    private Autoridad autoridad;


    public ProcesoElectoral(){};

    public Autoridad getAutoridad() {
        return autoridad;
    }
    public void setAutoridad(Autoridad autoridad) {
        this.autoridad = autoridad;
    }
    public Jurado getJurado() {
        return jurado;
    }
    public void setJurado(Jurado jurado) {
        this.jurado = jurado;
    }
    public PartidoPoliticos getPartidoPoliticos() {
        return partidoPoliticos;
    }
    public void setPartidoPoliticos(PartidoPoliticos partidoPoliticos) {
        this.partidoPoliticos = partidoPoliticos;
    }
    public Mesas getMesas() {
        return mesas;
    }
    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }

    public List<PustosVotacion> getPustosVotacion() {
        return pustosVotacion;
    }


    public Candidatos getCandidatos() {
        return candidatos;
    }
    public void setCandidatos(Candidatos candidatos) {
        this.candidatos = candidatos;
    }

    public void mostrarResultados(){
        List<String>res;
        for(PustosVotacion pv : pustosVotacion){
           res= pv.getResultados();
        }
    }
}
