package org.fis.grupo5.electoral.estado;

import org.fis.grupo5.electoral.ProcesoElectoral;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

/**
 * Estado inicial. AÃºn no se permiten inscripciones ni votaciones.
 */
public class EstadoProgramado implements EstadoProceso {

    @Override
    public void inscribirCandidato(ProcesoElectoral proceso, Candidato candidato) {
        throw new IllegalStateException("El proceso estÃ¡ en estado Programado. No se pueden inscribir candidatos en este momento.");
    }

    @Override
    public void asignarJurado(ProcesoElectoral proceso, Jurado jurado) {
        throw new IllegalStateException("El proceso estÃ¡ en estado Programado. No se pueden asignar jurados en este momento.");
    }

    @Override
    public void registrarActa(ProcesoElectoral proceso, Acta acta) {
        throw new IllegalStateException("El proceso estÃ¡ en estado Programado. No se pueden registrar actas en este momento.");
    }

    @Override
    public String consultarResultados(ProcesoElectoral proceso) {
        throw new IllegalStateException("El proceso estÃ¡ en estado Programado. No se pueden consultar resultados en este momento.");
    }

    @Override
    public EstadoProceso siguiente() {
        return new EstadoInscripcion();
    }

    @Override
    public String getNombre() {
        return "Programado";
    }
}
