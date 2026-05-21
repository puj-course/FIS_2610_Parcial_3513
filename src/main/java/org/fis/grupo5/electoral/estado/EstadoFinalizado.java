package org.fis.grupo5.electoral.estado;

import org.fis.grupo5.electoral.ProcesoElectoral;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;

import java.util.HashMap;
import java.util.Map;

/**
 * Estado terminal de las elecciones. Los resultados son definitivos y no se permiten mÃ¡s cambios.
 */
public class EstadoFinalizado implements EstadoProceso {

    @Override
    public void inscribirCandidato(ProcesoElectoral proceso, Candidato candidato) {
        throw new IllegalStateException("El proceso ha Finalizado. No se pueden inscribir candidatos.");
    }

    @Override
    public void asignarJurado(ProcesoElectoral proceso, Jurado jurado) {
        throw new IllegalStateException("El proceso ha Finalizado. No se pueden asignar jurados.");
    }

    @Override
    public void registrarActa(ProcesoElectoral proceso, Acta acta) {
        throw new IllegalStateException("El proceso ha Finalizado. No se pueden registrar actas.");
    }

    @Override
    public String consultarResultados(ProcesoElectoral proceso) {
        if (proceso.getActas().isEmpty()) {
            return "Resultados Definitivos: Sin actas registradas.";
        }

        Map<Candidato, Integer> consolidado = new HashMap<>();
        for (Acta acta : proceso.getActas()) {
            acta.getResultados().forEach((candidato, votos) -> 
                consolidado.put(candidato, consolidado.getOrDefault(candidato, 0) + votos)
            );
        }

        if (consolidado.isEmpty()) {
            return "Resultados Definitivos: Las actas registradas no contienen votos.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== BOLETÃN DE RESULTADOS FINALES Y DEFINITIVOS (PROCESO CERRADO) ===\n");
        consolidado.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> sb.append(String.format("Candidato Electo: %s (%s) - Votos: %d\n",
                        entry.getKey().getNombre(),
                        entry.getKey().getPartido(),
                        entry.getValue())));
        sb.append(String.format("Total Votos Escrutados Definitivos: %d\n",
                consolidado.values().stream().mapToInt(Integer::intValue).sum()));
        sb.append("El proceso electoral se declara cerrado oficialmente y en firme.");
        
        return sb.toString();
    }

    @Override
    public EstadoProceso siguiente() {
        throw new IllegalStateException("El proceso electoral ya ha finalizado y se encuentra en su estado terminal.");
    }

    @Override
    public String getNombre() {
        return "Finalizado";
    }
}
