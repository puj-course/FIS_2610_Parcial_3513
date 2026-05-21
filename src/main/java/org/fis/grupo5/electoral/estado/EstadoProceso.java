package org.fis.grupo5.electoral.estado;

import org.fis.grupo5.electoral.ProcesoElectoral;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

/**
 * Interfaz que define las operaciones permitidas en cada estado
 * del calendario electoral.
 */
public interface EstadoProceso {
    void inscribirCandidato(ProcesoElectoral proceso, Candidato candidato);
    void asignarJurado(ProcesoElectoral proceso, Jurado jurado);
    void registrarActa(ProcesoElectoral proceso, Acta acta);
    String consultarResultados(ProcesoElectoral proceso);
    EstadoProceso siguiente();
    String getNombre();
}
