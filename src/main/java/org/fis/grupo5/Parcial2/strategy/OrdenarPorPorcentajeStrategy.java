package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.ArrayList;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: STRATEGY — Estrategia Concreta #2
 * =========================================================
 * Ordena los ResultadoCandidato por porcentaje de votos obtenidos
 * respecto al total del Acta (de mayor a menor).
 * Útil cuando los analistas necesitan comparar proporciones entre
 * mesas con diferente censo, no solo totales absolutos.
 */
public class OrdenarPorPorcentajeStrategy implements EstrategiaOrdenamiento {

    @Override
    public List<ResultadoCandidato> ordenar(Acta acta) {
        int totalVotos = acta.getResultados().stream()
                .mapToInt(ResultadoCandidato::getVotos)
                .sum();

        List<ResultadoCandidato> resultado = new ArrayList<>(acta.getResultados());

        if (totalVotos == 0) return resultado; // evita división por cero

        resultado.sort((a, b) -> {
            double pctA = (a.getVotos() * 100.0) / totalVotos;
            double pctB = (b.getVotos() * 100.0) / totalVotos;
            return Double.compare(pctB, pctA); // descendente
        });

        return resultado;
    }

    @Override
    public String getNombreEstrategia() {
        return "Ordenar por Porcentaje de Votos";
    }

    /**
     * Calcula el porcentaje de un resultado respecto al total del Acta.
     */
    public double calcularPorcentaje(ResultadoCandidato rc, Acta acta) {
        int total = acta.getResultados().stream()
                .mapToInt(ResultadoCandidato::getVotos).sum();
        return total == 0 ? 0.0 : (rc.getVotos() * 100.0) / total;
    }
}
