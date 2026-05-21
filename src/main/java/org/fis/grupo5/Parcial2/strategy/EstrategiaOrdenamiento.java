package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: STRATEGY
 * =================================
 * Interfaz Estrategia (Strategy).
 * Define el algoritmo de análisis/ordenamiento de resultados electorales.
 *
 * Justificación:
 *   Una vez cerradas las mesas, los analistas electorales necesitan
 *   procesar los ResultadoCandidato de un Acta de formas distintas:
 *   ordenar por total de votos, por porcentaje, o agrupar por partido.
 *   El patrón Strategy permite intercambiar el algoritmo en tiempo de
 *   ejecución sin modificar AnalizadorResultados (el contexto),
 *   cumpliendo el principio Open/Closed.
 */
public interface EstrategiaOrdenamiento {

    /**
     * Procesa y ordena la lista de resultados del Acta según el criterio
     * de esta estrategia concreta.
     *
     * @param acta   El Acta con los ResultadoCandidato a procesar.
     * @return       Lista ordenada de ResultadoCandidato según el criterio.
     */
    List<ResultadoCandidato> ordenar(Acta acta);

    /**
     * Nombre descriptivo de la estrategia (para reportes).
     */
    String getNombreEstrategia();
}
