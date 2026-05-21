package org.fis.grupo5.electoral.estado;

import org.fis.grupo5.electoral.ProcesoElectoral;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

/**
 * Estado en el que transcurre la jornada electoral.
 * Se pueden asignar jurados a las mesas y registrar las actas resultantes.
 */
public class EstadoVotacion implements EstadoProceso {

    @Override
    public void inscribirCandidato(ProcesoElectoral proceso, Candidato candidato) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de VotaciÃ³n. Ya no se permite inscribir candidatos.");
    }

    @Override
    public void asignarJurado(ProcesoElectoral proceso, Jurado jurado) {
        if (jurado == null) {
            throw new IllegalArgumentException("El jurado no puede ser nulo.");
        }
        proceso.addJuradoInternal(jurado);
    }

    @Override
    public void registrarActa(ProcesoElectoral proceso, Acta acta) {
        if (acta == null) {
            throw new IllegalArgumentException("El acta no puede ser nula.");
        }
        proceso.addActaInternal(acta);
    }

    @Override
    public String consultarResultados(ProcesoElectoral proceso) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de VotaciÃ³n. No se pueden consultar resultados consolidados hasta el Escrutinio.");
    }

    @Override
    public EstadoProceso siguiente() {
        return new EstadoEscrutinio();
    }

    @Override
    public String getNombre() {
        return "VotaciÃ³n";
    }
}
