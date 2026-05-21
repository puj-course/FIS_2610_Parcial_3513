package org.fis.grupo5.Parcial2.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProcesoElectoral {
    private int id;
    private String tipoEleccion;
    private LocalDate fecha;
    private String estado;
    private List<Departamento> departamentos;
    private List<Candidato> candidatos;

    public ProcesoElectoral(int id, String tipoEleccion, LocalDate fecha, String estado) {
        this.id = id;
        this.tipoEleccion = tipoEleccion;
        this.fecha = fecha;
        this.estado = estado;
        this.departamentos = new ArrayList<>();
        this.candidatos = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoEleccion() { return tipoEleccion; }
    public void setTipoEleccion(String tipoEleccion) { this.tipoEleccion = tipoEleccion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<Departamento> getDepartamentos() { return departamentos; }
    public void setDepartamentos(List<Departamento> departamentos) { this.departamentos = departamentos; }

    public List<Candidato> getCandidatos() { return candidatos; }
    public void setCandidatos(List<Candidato> candidatos) { this.candidatos = candidatos; }
}