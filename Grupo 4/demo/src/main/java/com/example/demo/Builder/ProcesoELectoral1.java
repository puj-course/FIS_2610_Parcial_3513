package com.example.demo.Builder;

public class ProcesoELectoral1 implements ProcesosElectorales {
    private ProcesoElectoral procesosElectoral;

    public ProcesoELectoral1(ProcesoElectoral procesosElectoral) {
        this.procesosElectoral = procesosElectoral;
    }

    @Override
    public void reset() {
        procesosElectoral = new ProcesoElectoral();
    }

    @Override
    public void anadirTipoDeEleccion(String tipoEleccion) {
        procesosElectoral.setTipoEleccion(tipoEleccion);
    }

    @Override
    public ProcesoElectoral getResultado() {
        return procesosElectoral;
    }
}
