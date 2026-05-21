package org.fis.grupo1.parcial2;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private List<Municipio> municipios;
    private String codigo;

    public Integer conteoVotos(){
        Integer total=0;
        for(Municipio m: municipios){
            total+= m.contarVotos();
        }
        return total;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public String getCodigo() {
        return codigo;
    }
}
