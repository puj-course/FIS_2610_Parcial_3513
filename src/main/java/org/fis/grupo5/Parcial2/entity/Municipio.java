package org.fis.grupo5.Parcial2.entity;
import java.util.ArrayList;
import java.util.List;

public class Municipio {
    private int id;
    private String nombre;
    private Departamento departamento;
    private List<PuestoDeVotacion> puestos;

    public Municipio(int id, String nombre, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.puestos = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

    public List<PuestoDeVotacion> getPuestos() { return puestos; }
    public void setPuestos(List<PuestoDeVotacion> puestos) { this.puestos = puestos; }
}