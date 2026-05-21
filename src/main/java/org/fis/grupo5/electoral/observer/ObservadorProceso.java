package org.fis.grupo5.electoral.observer;

import org.fis.grupo5.electoral.modelo.Acta;

/**
 * Interfaz que define a los observadores interesados en
 * recibir actualizaciones de actas de votaciÃ³n.
 */
public interface ObservadorProceso {
    /**
     * Se invoca cuando una mesa de votaciÃ³n registra su acta de escrutinio.
     *
     * @param mesaId Identificador de la mesa de votaciÃ³n.
     * @param acta   Acta de escrutinio con los resultados consolidados.
     */
    void actualizar(String mesaId, Acta acta);

    /**
     * Retorna el nombre descriptivo del observador para fines informativos y de log.
     */
    String getNombre();
}
