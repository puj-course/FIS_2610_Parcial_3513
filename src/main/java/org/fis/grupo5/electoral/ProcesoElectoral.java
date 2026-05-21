package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.estado.EstadoProceso;
import org.fis.grupo5.electoral.estado.EstadoProgramado;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contexto del patrÃ³n State. Representa el proceso electoral y
 * delega sus operaciones en el estado actual del calendario electoral.
 */
public class ProcesoElectoral {
    private final String nombre;
    private final String tipoEleccion;
    private final LocalDate fecha;
    
    private EstadoProceso estadoActual;
    
    private final List<Candidato> candidatos;
    private final List<Jurado> jurados;
    private final List<Acta> actas;

    public ProcesoElectoral(String nombre, String tipoEleccion, LocalDate fecha) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proceso electoral no puede ser nulo o vacÃ­o.");
        }
        if (tipoEleccion == null || tipoEleccion.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de elecciÃ³n no puede ser nulo o vacÃ­o.");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha del proceso electoral no puede ser nula.");
        }
        this.nombre = nombre.trim();
        this.tipoEleccion = tipoEleccion.trim();
        this.fecha = fecha;
        
        // Estado inicial
        this.estadoActual = new EstadoProgramado();
        
        this.candidatos = new ArrayList<>();
        this.jurados = new ArrayList<>();
        this.actas = new ArrayList<>();
    }

    // DelegaciÃ³n del comportamiento al estado actual
    
    public void inscribirCandidato(Candidato candidato) {
        estadoActual.inscribirCandidato(this, candidato);
    }

    public void asignarJurado(Jurado jurado) {
        estadoActual.asignarJurado(this, jurado);
    }

    public void registrarActa(Acta acta) {
        estadoActual.registrarActa(this, acta);
    }

    public String consultarResultados() {
        return estadoActual.consultarResultados(this);
    }

    /**
     * Avanza al siguiente estado en la secuencia del calendario electoral.
     */
    public void avanzarEstado() {
        this.estadoActual = estadoActual.siguiente();
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getTipoEleccion() {
        return tipoEleccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoProceso getEstadoActual() {
        return estadoActual;
    }

    public List<Candidato> getCandidatos() {
        return Collections.unmodifiableList(candidatos);
    }

    public List<Jurado> getJurados() {
        return Collections.unmodifiableList(jurados);
    }

    public List<Acta> getActas() {
        return Collections.unmodifiableList(actas);
    }

    // MÃ©todos package-private para que los estados concretos muten la informaciÃ³n

    public void addCandidatoInternal(Candidato candidato) {
        if (candidatos.contains(candidato)) {
            throw new IllegalArgumentException("El candidato con ID " + candidato.getId() + " ya estÃ¡ inscrito.");
        }
        candidatos.add(candidato);
    }

    public void addJuradoInternal(Jurado jurado) {
        if (jurados.contains(jurado)) {
            throw new IllegalArgumentException("El jurado con ID " + jurado.getId() + " ya estÃ¡ asignado.");
        }
        jurados.add(jurado);
    }

    public void addActaInternal(Acta acta) {
        // Verificar que no se registre dos veces la misma acta o misma mesa
        for (Acta a : actas) {
            if (a.getId().equals(acta.getId())) {
                throw new IllegalArgumentException("El acta con ID " + acta.getId() + " ya estÃ¡ registrada.");
            }
            if (a.getMesaId().equals(acta.getMesaId())) {
                throw new IllegalArgumentException("Ya se registrÃ³ un acta para la mesa de votaciÃ³n " + acta.getMesaId());
            }
        }
        actas.add(acta);
    }

    // Para fines de pruebas/testing unitario del estado directamente
    public void setEstadoActualInternal(EstadoProceso nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }
}
