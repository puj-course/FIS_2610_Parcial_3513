package org.fis.grupo1;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    String pais;
    String nombre;
    List<Municipio> municipios;

    public Departamento(String pais, String nombre) {
        this.pais = pais;
        this.municipios = new ArrayList<>();
    }

}
