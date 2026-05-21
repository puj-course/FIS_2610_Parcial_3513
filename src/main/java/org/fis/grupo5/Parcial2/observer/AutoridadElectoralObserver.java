package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.ArrayList;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: OBSERVER — Observador Concreto #1
 * =========================================================
 * Representa a la Autoridad Electoral (Registraduría Nacional).
 * Al recibir cada Acta, la consolida en el registro oficial
 * para la publicación de resultados nacionales.
 */
public class AutoridadElectoralObserver implements ObservadorActa {

    private final List<Acta> actasConsolidadas = new ArrayList<>();
    private int totalVotosNacionales = 0;

    @Override
    public void actualizar(Acta acta) {
        actasConsolidadas.add(acta);

        // Sumar todos los votos registrados en el Acta
        int votosActa = acta.getResultados().stream()
                .mapToInt(ResultadoCandidato::getVotos)
                .sum();
        totalVotosNacionales += votosActa;

        System.out.println("\n  [AUTORIDAD ELECTORAL] Acta #" + acta.getId()
                + " consolidada — Mesa " + acta.getMesa().getNumero()
                + " | Votos en acta: " + votosActa
                + " | Total nacional: " + totalVotosNacionales);
    }

    /** Imprime el reporte oficial consolidado de todas las actas recibidas. */
    public void imprimirReporteConsolidado() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║     REPORTE OFICIAL — AUTORIDAD ELECTORAL        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("  Actas procesadas    : " + actasConsolidadas.size());
        System.out.println("  Total votos nacionales: " + totalVotosNacionales);
    }

    public List<Acta> getActasConsolidadas()  { return actasConsolidadas; }
    public int getTotalVotosNacionales()       { return totalVotosNacionales; }
}
