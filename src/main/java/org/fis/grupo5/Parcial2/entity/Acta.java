package org.fis.grupo5.Parcial2.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Acta {
    private int id;
    private Mesa mesa;
    private LocalDateTime fechaCierre;
    private List<ResultadoCandidato> resultados;
    private List<Incidente> incidentes;
    private List<Reclamacion> reclamaciones;

    public Acta(int id, Mesa mesa, LocalDateTime fechaCierre) {
        this.id = id;
        this.mesa = mesa;
        this.fechaCierre = fechaCierre;
        this.resultados = new ArrayList<>();
        this.incidentes = new ArrayList<>();
        this.reclamaciones = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }

    public LocalDateTime getFechaCierre() { return fechaCierre; }
    public void setFechaCierre(LocalDateTime fechaCierre) { this.fechaCierre = fechaCierre; }

    public List<ResultadoCandidato> getResultados() { return resultados; }
    public void setResultados(List<ResultadoCandidato> resultados) { this.resultados = resultados; }

    public List<Incidente> getIncidentes() { return incidentes; }
    public void setIncidentes(List<Incidente> incidentes) { this.incidentes = incidentes; }

    public List<Reclamacion> getReclamaciones() { return reclamaciones; }
    public void setReclamaciones(List<Reclamacion> reclamaciones) { this.reclamaciones = reclamaciones; }
}