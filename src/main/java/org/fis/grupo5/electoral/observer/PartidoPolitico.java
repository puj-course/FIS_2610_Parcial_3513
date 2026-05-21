package org.fis.grupo5.electoral.observer;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;

import java.util.Map;

/**
 * Observador concreto que representa a un partido polÃ­tico.
 * Vigila los votos obtenidos exclusivamente por los candidatos de su propio partido.
 */
public class PartidoPolitico implements ObservadorProceso {
    private final String nombrePartido;

    public PartidoPolitico(String nombrePartido) {
        if (nombrePartido == null || nombrePartido.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del partido polÃ­tico no puede ser nulo o vacÃ­o.");
        }
        this.nombrePartido = nombrePartido.trim();
    }

    @Override
    public void actualizar(String mesaId, Acta acta) {
        if (acta == null) {
            return;
        }

        int votosPartido = 0;
        System.out.println("\n--- [VIGILANCIA PARTIDISTA] " + nombrePartido.toUpperCase() + " en MESA: " + mesaId + " ---");
        
        for (Map.Entry<Candidato, Integer> resultado : acta.getResultados().entrySet()) {
            Candidato candidato = resultado.getKey();
            int votos = resultado.getValue();
            
            if (candidato.getPartido().equalsIgnoreCase(this.nombrePartido)) {
                System.out.println(" > Candidato: " + candidato.getNombre() + " | Votos obtenidos: " + votos);
                votosPartido += votos;
            }
        }
        
        System.out.println(" > Votos Totales para " + nombrePartido + " en esta mesa: " + votosPartido);
    }

    @Override
    public String getNombre() {
        return "Partido PolÃ­tico: " + nombrePartido;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }
}
