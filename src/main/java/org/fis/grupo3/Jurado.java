package org.fis.grupo3;

public class Jurado {
    private int idJurado;
    private String cedula;
    private String funcion;
    private int mesaId;
    public Jurado(int idJurado, String cedula, String funcion, int mesaId) {
        this.idJurado = idJurado;
        this.cedula = cedula;
        this.funcion = funcion;
        this.mesaId = mesaId;
    }
    public int getIdJurado(){
        return idJurado;
    }
    public void setIdJurado(int idJurado){
        this.idJurado = idJurado;
    }
    public String getCedula(){
        return cedula;
    }
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    public String getFuncion(){
        return funcion;
    }
    public void setFuncion(String funcion){
        this.funcion = funcion;
    }
    public int getMesaId(){
        return mesaId;
    }
    public void setMesaId(int mesaId){
        this.mesaId = mesaId;
    }
    public void instalarMesas(){
        System.out.println("Mesa " + mesaId + " instalada por el jurado.");
    }
    public void atenderVotante(){
        System.out.println("El jurado está atendiendo a un votante.");
    }
    public int registrarResultado(){
        int resultado = 0;
        System.out.println("Resultados registrados.");
        return resultado;
    }
}