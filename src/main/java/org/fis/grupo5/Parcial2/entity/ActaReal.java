package org.fis.grupo5.Parcial2.entity;
import org.fis.grupo5.Parcial2.service.IActa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActaReal implements IActa {
    private int id;
    private Mesa mesa;
    private LocalDateTime fechaCierre;
    private List<ResultadoCandidato> resultados;
    private List<Incidente> incidentes;
    private List<Reclamacion> reclamaciones;

    public ActaReal(int id, Mesa mesa, LocalDateTime fechaCierre) {
        this.id = id;
        this.mesa = mesa;
        this.fechaCierre = fechaCierre;
        this.resultados = new ArrayList<>();
        this.incidentes = new ArrayList<>();
        this.reclamaciones = new ArrayList<>();
    }

    public int getId() { return id; }
    public Mesa getMesa() { return mesa; }
    public LocalDateTime getFechaCierre() { return fechaCierre; }

    public List<ResultadoCandidato> getResultados() { return resultados; }

    public void agregarResultado(ResultadoCandidato resultado) {
        resultados.add(resultado);
    }

    public void agregarIncidente(Incidente incidente) {
        incidentes.add(incidente);
    }

    public void agregarReclamacion(Reclamacion reclamacion) {
        reclamaciones.add(reclamacion);
    }

    public List<Incidente> getIncidentes() { return incidentes; }
    public List<Reclamacion> getReclamaciones() { return reclamaciones; }
}
