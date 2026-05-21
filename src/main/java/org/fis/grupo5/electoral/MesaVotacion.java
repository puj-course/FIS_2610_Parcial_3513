package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.observer.ObservadorProceso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa el Subject en el patrÃ³n Observer.
 * Modela una mesa de votaciÃ³n que notifica a sus observadores registrados
 * una vez que se registra su acta de escrutinio definitiva.
 */
public class MesaVotacion {
    private final String id;
    private final List<ObservadorProceso> observadores;
    private Acta actaActual;

    public MesaVotacion(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la mesa de votaciÃ³n no puede ser nulo o vacÃ­o.");
        }
        this.id = id.trim();
        this.observadores = new ArrayList<>();
    }

    public void registrarObservador(ObservadorProceso observador) {
        if (observador == null) {
            throw new IllegalArgumentException("El observador no puede ser nulo.");
        }
        if (observadores.contains(observador)) {
            throw new IllegalArgumentException("El observador '" + observador.getNombre() + "' ya estÃ¡ registrado en esta mesa.");
        }
        observadores.add(observador);
    }

    public void removerObservador(ObservadorProceso observador) {
        if (observador == null) {
            throw new IllegalArgumentException("El observador no puede ser nulo.");
        }
        if (!observadores.contains(observador)) {
            throw new IllegalArgumentException("El observador '" + observador.getNombre() + "' no se encuentra registrado en esta mesa.");
        }
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        if (actaActual == null) {
            return;
        }
        for (ObservadorProceso obs : observadores) {
            obs.actualizar(this.id, this.actaActual);
        }
    }

    public void registrarActa(Acta acta) {
        if (acta == null) {
            throw new IllegalArgumentException("El acta a registrar no puede ser nula.");
        }
        if (!acta.getMesaId().equals(this.id)) {
            throw new IllegalArgumentException("El acta no corresponde a esta mesa de votaciÃ³n (ID mesa acta: " 
                    + acta.getMesaId() + ", ID mesa actual: " + this.id + ").");
        }
        this.actaActual = acta;
        notificarObservadores();
    }

    public String getId() {
        return id;
    }

    public List<ObservadorProceso> getObservadores() {
        return Collections.unmodifiableList(observadores);
    }

    public Acta getActaActual() {
        return actaActual;
    }
}
