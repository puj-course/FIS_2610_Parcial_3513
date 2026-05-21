package com.example.demo.Builder;

public interface ProcesosElectorales {
    void reset();
    void anadirTipoDeEleccion(String tipoEleccion);
    ProcesoElectoral getResultado();
}
