package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: STRATEGY — Estrategia Concreta #1
 * =========================================================
 * Ordena los ResultadoCandidato de mayor a menor número de votos.
 * Es el criterio estándar para publicar resultados oficiales
 * y determinar el ganador de la elección.
 */
public class OrdenarPorVotosStrategy implements EstrategiaOrdenamiento {

    @Override
    public List<ResultadoCandidato> ordenar(Acta acta) {
        List<ResultadoCandidato> resultado = new ArrayList<>(acta.getResultados());
        resultado.sort(Comparator.comparingInt(ResultadoCandidato::getVotos).reversed());
        return resultado;
    }

    @Override
    public String getNombreEstrategia() {
        return "Ordenar por Votos (mayor a menor)";
    }
}
