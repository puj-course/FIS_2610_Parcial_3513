package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: STRATEGY — Estrategia Concreta #3
 * =========================================================
 * Ordena los ResultadoCandidato alfabéticamente por partido político
 * y, dentro del mismo partido, por mayor número de votos.
 * Útil para que los partidos consulten el desempeño de todos
 * sus candidatos agrupados y en orden comparable.
 */
public class OrdenarPorPartidoStrategy implements EstrategiaOrdenamiento {

    @Override
    public List<ResultadoCandidato> ordenar(Acta acta) {
        List<ResultadoCandidato> resultado = new ArrayList<>(acta.getResultados());

        resultado.sort(Comparator
                // 1°: por nombre de partido (alfabético)
                .comparing(rc -> {
                    String partido = rc.getCandidato().getPartido() != null
                            ? rc.getCandidato().getPartido().getNombre()
                            : "ZZZ_SIN_PARTIDO"; // sin partido al final
                    return partido;
                })
                // 2°: dentro del mismo partido, mayor votos primero
                .thenComparing(Comparator
                        .comparingInt(ResultadoCandidato::getVotos)
                        .reversed())
        );

        return resultado;
    }

    @Override
    public String getNombreEstrategia() {
        return "Ordenar por Partido Político (alfabético) y Votos";
    }
}
