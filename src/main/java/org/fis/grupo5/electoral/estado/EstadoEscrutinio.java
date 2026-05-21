package org.fis.grupo5.electoral.estado;

import org.fis.grupo5.electoral.ProcesoElectoral;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Estado en el que se consolidan y analizan los votos de todas las mesas de votaciÃ³n.
 */
public class EstadoEscrutinio implements EstadoProceso {

    @Override
    public void inscribirCandidato(ProcesoElectoral proceso, Candidato candidato) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de Escrutinio. No se pueden inscribir candidatos.");
    }

    @Override
    public void asignarJurado(ProcesoElectoral proceso, Jurado jurado) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de Escrutinio. No se pueden asignar jurados.");
    }

    @Override
    public void registrarActa(ProcesoElectoral proceso, Acta acta) {
        throw new IllegalStateException("El proceso estÃ¡ en estado de Escrutinio. No se pueden registrar nuevas actas.");
    }

    @Override
    public String consultarResultados(ProcesoElectoral proceso) {
        if (proceso.getActas().isEmpty()) {
            return "Sin resultados: No hay actas registradas.";
        }

        Map<Candidato, Integer> consolidado = new HashMap<>();
        for (Acta acta : proceso.getActas()) {
            acta.getResultados().forEach((candidato, votos) -> 
                consolidado.put(candidato, consolidado.getOrDefault(candidato, 0) + votos)
            );
        }

        if (consolidado.isEmpty()) {
            return "Sin resultados: Las actas registradas no contienen votos.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("--- RESULTADOS CONSOLIDADOS (ESCRUTINIO) ---\n");
        consolidado.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordenar de mayor a menor votos
                .forEach(entry -> sb.append(String.format("Candidato: %s (%s) - Votos: %d\n",
                        entry.getKey().getNombre(),
                        entry.getKey().getPartido(),
                        entry.getValue())));
        sb.append(String.format("Total Votos Escrutados: %d",
                consolidado.values().stream().mapToInt(Integer::intValue).sum()));
        
        return sb.toString();
    }

    @Override
    public EstadoProceso siguiente() {
        return new EstadoFinalizado();
    }

    @Override
    public String getNombre() {
        return "Escrutinio";
    }
}
