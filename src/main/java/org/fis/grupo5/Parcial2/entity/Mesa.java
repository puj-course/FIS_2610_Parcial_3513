package org.fis.grupo5.Parcial2.entity;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int id;
    private int numero;
    private int censoAproximado;
    private PuestoDeVotacion puesto;
    private List<Jurado> jurados;

    public Mesa(int id, int numero, int censoAproximado, PuestoDeVotacion puesto) {
        this.id = id;
        this.numero = numero;
        this.censoAproximado = censoAproximado;
        this.puesto = puesto;
        this.jurados = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getCensoAproximado() { return censoAproximado; }
    public void setCensoAproximado(int censoAproximado) { this.censoAproximado = censoAproximado; }

    public PuestoDeVotacion getPuesto() { return puesto; }
    public void setPuesto(PuestoDeVotacion puesto) { this.puesto = puesto; }

    public List<Jurado> getJurados() { return jurados; }
    public void setJurados(List<Jurado> jurados) { this.jurados = jurados; }
}