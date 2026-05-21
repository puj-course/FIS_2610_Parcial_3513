package org.fis.grupo5.Parcial2.entity;
import java.util.ArrayList;
import java.util.List;

public class PartidoPolitico {
    private int id;
    private String nombre;
    private List<Candidato> candidatos;

    public PartidoPolitico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.candidatos = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Candidato> getCandidatos() { return candidatos; }
    public void setCandidatos(List<Candidato> candidatos) { this.candidatos = candidatos; }
}