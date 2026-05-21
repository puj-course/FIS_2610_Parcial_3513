package org.fis.grupo5.electoral.estado;

import org.fis.grupo5.electoral.ProcesoElectoral;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

/**
 * Estado que permite registrar candidatos para las elecciones.
 */
public class EstadoInscripcion implements EstadoProceso {

    @Override
    public void inscribirCandidato(ProcesoElectoral proceso, Candidato candidato) {
        if (candidato == null) {
            throw new IllegalArgumentException("El candidato no puede ser nulo.");
        }
        proceso.addCandidatoInternal(candidato);
    }

    @Override
    public void asignarJurado(ProcesoElectoral proceso, Jurado jurado) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de InscripciÃ³n. No se pueden asignar jurados en este momento.");
    }

    @Override
    public void registrarActa(ProcesoElectoral proceso, Acta acta) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de InscripciÃ³n. No se pueden registrar actas en este momento.");
    }

    @Override
    public String consultarResultados(ProcesoElectoral proceso) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de InscripciÃ³n. No se pueden consultar resultados en este momento.");
    }

    @Override
    public EstadoProceso siguiente() {
        return new EstadoVotacion();
    }

    @Override
    public String getNombre() {
        return "InscripciÃ³n";
    }
}
