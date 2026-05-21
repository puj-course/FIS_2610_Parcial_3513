package org.fis.grupo1.parcial2.strategy;

import org.fis.grupo1.parcial2.Departamento;
import org.fis.grupo1.parcial2.Municipio;
import org.fis.grupo1.parcial2.SistemaElectoral;

public class ConteoVotosMunicipio implements ConteoVotos<Integer>{
    SistemaElectoral sistemaElectoral;

    @Override
    public Integer progreso(String codigo) {

        for(Departamento departamento : sistemaElectoral.getDepartamentos()){
            for(Municipio m : departamento.getMunicipios()){

                if(m.getCodigo() == codigo){
                    return m.contarVotos();
                }
            }
        }


        return 0;
    }
}
