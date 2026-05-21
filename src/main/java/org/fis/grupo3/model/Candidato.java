package org.fis.grupo3.model;

public class Candidato {
    private String cedula;
    private String numeroTarjeton;
    private CandidatoStrategy strategy;

    public Candidato(String cedula, String numeroTarjeton) {
        this.cedula = cedula;
        this.numeroTarjeton = numeroTarjeton;
        this.strategy = new ValidacionCompletaStrategy();
    }
    public void setStrategy(CandidatoStrategy strategy) { this.strategy = strategy;}
    public boolean processar() { return strategy.ejecutar(this); }
    public String getCedula (){
        return cedula;
    }

    public String getNumeroTarjeton (){
        return numeroTarjeton;
    }
}
