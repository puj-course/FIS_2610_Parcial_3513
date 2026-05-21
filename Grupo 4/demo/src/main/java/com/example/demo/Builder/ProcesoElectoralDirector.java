package com.example.demo.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProcesoElectoralDirector {
    private ProcesosElectorales procesosElectorales;

    public ProcesoElectoralDirector(ProcesosElectorales procesosElectorales) {
        this.procesosElectorales = procesosElectorales;
    }

    public void makeProceso(){
        procesosElectorales.reset();
        procesosElectorales.anadirTipoDeEleccion("Tipo de Eleccion");
    }
}
