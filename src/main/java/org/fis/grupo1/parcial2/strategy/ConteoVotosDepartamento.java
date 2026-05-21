package org.fis.grupo1.parcial2.strategy;

import org.fis.grupo1.parcial2.Departamento;
import org.fis.grupo1.parcial2.SistemaElectoral;

public class ConteoVotosDepartamento implements ConteoVotos<Integer>{

    SistemaElectoral sistemaElectoral;

    @Override
    public Integer progreso(String codigo){

        for(Departamento d: sistemaElectoral.getDepartamentos()){
            if(d.getCodigo() == codigo){
                return  d.conteoVotos();
            }
        }
        return 0;
    }

}
