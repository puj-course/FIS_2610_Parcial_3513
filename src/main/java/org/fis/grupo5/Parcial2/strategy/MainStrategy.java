package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.*;
import java.time.LocalDateTime;

/**
 * DEMOSTRACIÓN del Patrón Strategy con las entidades reales del Grupo 5.
 *
 * Escenario:
 *   Un Analista Electoral recibe el Acta de la Mesa 3 y la procesa
 *   con tres criterios distintos, cambiando la estrategia en caliente:
 *   1. Por votos absolutos   → para el informe oficial
 *   2. Por porcentaje        → para el análisis comparativo
 *   3. Por partido           → para el informe a los partidos
 */
public class MainStrategy {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║  PATRÓN STRATEGY — SISTEMA ELECTORAL COLOMBIANO 2026     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        // ── 1. Entidades del dominio ────────────────────────────────────────
        PartidoPolitico verde  = new PartidoPolitico(1, "Partido Verde");
        PartidoPolitico azul   = new PartidoPolitico(2, "Partido Azul");
        PartidoPolitico rojo   = new PartidoPolitico(3, "Partido Rojo");

        Candidato c1 = new Candidato(1, "Ana Ruiz",      "101", verde);
        Candidato c2 = new Candidato(2, "Luis Torres",   "202", azul);
        Candidato c3 = new Candidato(3, "María López",   "303", verde);
        Candidato c4 = new Candidato(4, "Pedro Gómez",   "404", rojo);
        Candidato c5 = new Candidato(5, "Laura Mendez",  "505", azul);

        Municipio bogota = new Municipio(1, "Bogotá", null);
        PuestoDeVotacion puesto = new PuestoDeVotacion(1, "Colegio Nacional", "Cra 7 #45-10", bogota);
        Mesa mesaReal = new Mesa(3, 3, 500, puesto);

        // Acta con resultados
        Acta acta = new Acta(201, mesaReal, LocalDateTime.now());
        acta.getResultados().add(new ResultadoCandidato(1, c1, 185, acta));
        acta.getResultados().add(new ResultadoCandidato(2, c2, 142, acta));
        acta.getResultados().add(new ResultadoCandidato(3, c3,  98, acta));
        acta.getResultados().add(new ResultadoCandidato(4, c4,  61, acta));
        acta.getResultados().add(new ResultadoCandidato(5, c5,  14, acta));

        // ── 2. Contexto con estrategia inicial: Por Votos ──────────────────
        AnalizadorResultados analizador = new AnalizadorResultados(
                new OrdenarPorVotosStrategy()
        );
        System.out.println("\n▶ [1] INFORME OFICIAL — Por votos absolutos:");
        analizador.analizar(acta);

        // ── 3. Cambiar estrategia en caliente: Por Porcentaje ──────────────
        analizador.setEstrategia(new OrdenarPorPorcentajeStrategy());
        System.out.println("\n▶ [2] ANÁLISIS COMPARATIVO — Por porcentaje:");
        analizador.analizar(acta);

        // ── 4. Cambiar estrategia: Por Partido ────────────────────────────
        analizador.setEstrategia(new OrdenarPorPartidoStrategy());
        System.out.println("\n▶ [3] INFORME A PARTIDOS — Agrupado por partido:");
        analizador.analizar(acta);

        System.out.println("\n✅ El mismo Acta fue analizada con 3 estrategias diferentes.");
        System.out.println("   Sin modificar AnalizadorResultados (Open/Closed Principle).");
    }
}
