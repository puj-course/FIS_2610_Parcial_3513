package org.fis.grupo5.Parcial2.entity;
import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String nombre;
    private String codigo;
    private List<Municipio> municipios;

    public Departamento(int id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.municipios = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public List<Municipio> getMunicipios() { return municipios; }
    public void setMunicipios(List<Municipio> municipios) { this.municipios = municipios; }
}