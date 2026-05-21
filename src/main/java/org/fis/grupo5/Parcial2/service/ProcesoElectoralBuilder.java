package org.fis.grupo5.Parcial2.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class ProcesoElectoralBuilder {

    private int id;
    private String tipoEleccion;
    private LocalDate fecha;
    private String estado;

    public ProcesoElectoralBuilder conId(int id) {
        this.id = id;
        return this;
    }

    public ProcesoElectoralBuilder conTipoEleccion(String tipoEleccion) {
        this.tipoEleccion = tipoEleccion;
        return this;
    }

    public ProcesoElectoralBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public ProcesoElectoralBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ProcesoElectoral build() {
        return new ProcesoElectoral(id, tipoEleccion, fecha, estado);
    }
}