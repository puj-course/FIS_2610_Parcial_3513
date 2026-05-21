package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.Acta;

/**
 * PATRÓN COMPORTAMENTAL: OBSERVER
 * ================================
 * Interfaz Observer (Suscriptor).
 *
 * Todo actor que desee ser notificado cuando una Mesa registra
 * su Acta oficial debe implementar esta interfaz.
 *
 * Justificación:
 *   Cuando los jurados de una Mesa cierran la jornada y registran
 *   el Acta, múltiples actores del sistema electoral deben ser
 *   informados: la Autoridad Electoral para consolidar resultados,
 *   los Partidos Políticos para verificar sus votos e interponer
 *   reclamaciones, y los Analistas para procesar estadísticas.
 *   El patrón Observer desacopla la Mesa de sus observadores,
 *   permitiendo agregar nuevos actores sin modificar Mesa.
 */
public interface ObservadorActa {

    /**
     * Método invocado automáticamente por la Mesa (Subject)
     * cuando se publica un Acta oficial.
     *
     * @param acta El Acta registrada con sus resultados e incidentes.
     */
    void actualizar(Acta acta);
}
