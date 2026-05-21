package org.fis.grupo1.parcial2;

import java.util.List;

public class Municipio {
    private List<Mesa> mesas;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public Integer contarVotos(){
        Integer votos =0;

        for(Mesa m: mesas){
            votos+= m.getCantidadVotos();
        }
        return votos;
    }

}
