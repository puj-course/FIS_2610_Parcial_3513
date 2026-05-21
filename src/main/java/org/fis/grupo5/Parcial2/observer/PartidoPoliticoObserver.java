package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.Reclamacion;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.ArrayList;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: OBSERVER — Observador Concreto #2
 * =========================================================
 * Representa a un Partido Político suscrito al resultado de las Actas.
 * Al recibir el Acta, verifica si alguno de sus candidatos tiene
 * resultados sospechosos y revisa las reclamaciones existentes.
 */
public class PartidoPoliticoObserver implements ObservadorActa {

    private final String nombrePartido;
    private final List<String> alertas = new ArrayList<>();
    private int totalVotosObtenidos = 0;

    public PartidoPoliticoObserver(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    @Override
    public void actualizar(Acta acta) {
        System.out.println("\n  [PARTIDO - " + nombrePartido + "] Acta #"
                + acta.getId() + " recibida — Mesa "
                + acta.getMesa().getNumero());

        // Verificar resultados de candidatos del partido
        for (ResultadoCandidato rc : acta.getResultados()) {
            if (rc.getCandidato().getPartido() != null
                    && nombrePartido.equals(
                        rc.getCandidato().getPartido().getNombre())) {
                totalVotosObtenidos += rc.getVotos();
                System.out.println("  → Candidato: "
                        + rc.getCandidato().getNombre()
                        + " | Votos: " + rc.getVotos());
            }
        }

        // Verificar reclamaciones en el Acta que afecten al partido
        for (Reclamacion r : acta.getReclamaciones()) {
            String alerta = "ALERTA [" + nombrePartido + "] Acta #"
                    + acta.getId() + ": " + r.getMotivo();
            alertas.add(alerta);
            System.out.println("  ⚠ " + alerta);
        }

        System.out.println("  → Votos acumulados del partido: " + totalVotosObtenidos);
    }

    public String getNombrePartido()         { return nombrePartido; }
    public List<String> getAlertas()         { return alertas; }
    public int getTotalVotosObtenidos()      { return totalVotosObtenidos; }
}
