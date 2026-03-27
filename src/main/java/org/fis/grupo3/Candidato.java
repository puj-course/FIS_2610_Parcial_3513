package org.fis.grupo3;

public class Candidato {
    private String cedula;
    private String numeroTarjeton;

    public Candidato(String cedula, String numeroTarjeton) {
        this.cedula = cedula;
        this.numeroTarjeton = numeroTarjeton;
    }
    public String getCedula (){
        return cedula;
    }

    public String getNumeroTarjeton (){
        return numeroTarjeton;
    }
}
