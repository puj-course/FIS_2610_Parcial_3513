package org.fis.grupo5.Parcial2.entity;
public class Candidato {
    private int id;
    private String nombre;
    private String cedula;
    private PartidoPolitico partido;

    public Candidato(int id, String nombre, String cedula, PartidoPolitico partido) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.partido = partido;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public PartidoPolitico getPartido() { return partido; }
    public void setPartido(PartidoPolitico partido) { this.partido = partido; }
}