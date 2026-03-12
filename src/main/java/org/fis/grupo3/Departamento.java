package org.fis.grupo3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

//
public class Departamento {
    private int idDepartamento;
    private int nombre;
    private ArrayList<Municipio> municipios;


    public Departamento (int idDepartamento, int nombre, ArrayList<Municipio> municipios){
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.municipios = municipios;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }

    public int getNombre() {
        return nombre;
    }

    public void setMunicipios(ArrayList<Municipio> municipios) {
        this.municipios = municipios;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
