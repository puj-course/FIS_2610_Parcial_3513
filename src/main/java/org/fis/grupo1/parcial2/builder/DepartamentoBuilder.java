package org.fis.grupo1.parcial2.builder;

import org.fis.grupo1.parcial2.Departamento;
import org.fis.grupo1.parcial2.Municipio;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBuilder {
    private String codigo;
    private List<Municipio> municipios = new ArrayList<>();

    public DepartamentoBuilder setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public DepartamentoBuilder addMunicipio(Municipio municipio) {
        this.municipios.add(municipio);
        return this;
    }

    public Departamento build() {
        return new Departamento(codigo, municipios);
    }
}
