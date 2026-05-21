package org.fis.grupo5.electoral.observer;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;

import java.util.Map;

/**
 * Observador concreto que representa a un analista o medio de comunicaciÃ³n.
 * Realiza cÃ¡lculos estadÃ­sticos inmediatos e identifica al ganador de la mesa.
 */
public class AnalistaResultados implements ObservadorProceso {
    private final String nombreAnalista;

    public AnalistaResultados(String nombreAnalista) {
        if (nombreAnalista == null || nombreAnalista.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del analista no puede ser nulo o vacÃ­o.");
        }
        this.nombreAnalista = nombreAnalista.trim();
    }

    @Override
    public void actualizar(String mesaId, Acta acta) {
        if (acta == null || acta.getResultados().isEmpty()) {
            System.out.println("\n--- [ANÃLISIS ESTADÃSTICO] " + nombreAnalista.toUpperCase() + " en MESA: " + mesaId + " ---");
            System.out.println(" > Mesa sin registros de votaciÃ³n.");
            return;
        }

        System.out.println("\n--- [ANÃLISIS ESTADÃSTICO] " + nombreAnalista.toUpperCase() + " en MESA: " + mesaId + " ---");
        int totalVotos = acta.getTotalVotos();
        System.out.println(" > Total escrutado: " + totalVotos + " votos");

        Candidato ganador = null;
        int maxVotos = -1;

        for (Map.Entry<Candidato, Integer> entry : acta.getResultados().entrySet()) {
            if (entry.getValue() > maxVotos) {
                maxVotos = entry.getValue();
                ganador = entry.getKey();
            }
        }

        if (ganador != null) {
            double porcentaje = (double) maxVotos / totalVotos * 100;
            System.out.println(String.format(" > Candidato Ganador en esta mesa: %s (%s) con %d votos (%.2f%%)",
                    ganador.getNombre(), ganador.getPartido(), maxVotos, porcentaje));
        }
    }

    @Override
    public String getNombre() {
        return "Analista de Resultados: " + nombreAnalista;
    }

    public String getNombreAnalista() {
        return nombreAnalista;
    }
}
