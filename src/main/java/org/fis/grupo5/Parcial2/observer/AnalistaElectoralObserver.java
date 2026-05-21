package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;

/**
 * PATRÓN COMPORTAMENTAL: OBSERVER — Observador Concreto #3
 * =========================================================
 * Representa a un Analista Electoral que, al recibir cada Acta,
 * procesa estadísticas y genera reportes de comparación territorial.
 */
public class AnalistaElectoralObserver implements ObservadorActa {

    private final String nombreAnalista;
    private int totalActasAnalizadas = 0;

    public AnalistaElectoralObserver(String nombreAnalista) {
        this.nombreAnalista = nombreAnalista;
    }

    @Override
    public void actualizar(Acta acta) {
        totalActasAnalizadas++;
        int totalVotosActa = acta.getResultados().stream()
                .mapToInt(ResultadoCandidato::getVotos)
                .sum();

        System.out.println("\n  [ANALISTA - " + nombreAnalista + "] Acta #"
                + acta.getId() + " | Mesa " + acta.getMesa().getNumero()
                + " | Censo: " + acta.getMesa().getCensoAproximado()
                + " | Votos totales: " + totalVotosActa);

        System.out.println("  → Distribución por candidato:");
        for (ResultadoCandidato rc : acta.getResultados()) {
            double pct = totalVotosActa == 0 ? 0
                    : (rc.getVotos() * 100.0 / totalVotosActa);
            System.out.printf("     %-25s : %4d votos (%.1f%%)%n",
                    rc.getCandidato().getNombre(), rc.getVotos(), pct);
        }

        System.out.println("  → Incidentes registrados en acta: "
                + acta.getIncidentes().size());
        System.out.println("  → Total actas analizadas: " + totalActasAnalizadas);
    }

    public String getNombreAnalista()     { return nombreAnalista; }
    public int getTotalActasAnalizadas()  { return totalActasAnalizadas; }
}
