package org.fis.grupo5.Parcial2.entity;
import java.util.ArrayList;
import java.util.List;

public class PuestoDeVotacion {
    private int id;
    private String nombre;
    private String ubicacion;
    private Municipio municipio;
    private List<Mesa> mesas;

    public PuestoDeVotacion(int id, String nombre, String ubicacion, Municipio municipio) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.municipio = municipio;
        this.mesas = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public Municipio getMunicipio() { return municipio; }
    public void setMunicipio(Municipio municipio) { this.municipio = municipio; }

    public List<Mesa> getMesas() { return mesas; }
    public void setMesas(List<Mesa> mesas) { this.mesas = mesas; }
}