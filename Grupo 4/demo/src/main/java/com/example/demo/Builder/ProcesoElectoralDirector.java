package com.example.demo.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoElectoralDirector {
    private String tipoEleccion;
    private String fecha;
    private boolean estado;
}
