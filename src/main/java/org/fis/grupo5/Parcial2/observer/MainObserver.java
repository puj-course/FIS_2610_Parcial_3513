package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DEMOSTRACIÓN del Patrón Observer con las entidades reales del Grupo 5.
 *
 * Escenario:
 *   - Mesa #5 del "Colegio Bolívar" publica su Acta al cierre de jornada.
 *   - Tres actores suscriptos reciben la notificación automáticamente:
 *     AutoridadElectoral, PartidoPoliticoObserver, AnalistaElectoral.
 */
public class MainObserver {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║  PATRÓN OBSERVER — SISTEMA ELECTORAL COLOMBIANO 2026     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        // ── 1. Crear entidades del dominio ──────────────────────────────────
        PartidoPolitico partidoVerde = new PartidoPolitico(1, "Partido Verde");
        PartidoPolitico partidoAzul  = new PartidoPolitico(2, "Partido Azul");

        Candidato c1 = new Candidato(1, "Ana Ruiz",    "111111", partidoVerde);
        Candidato c2 = new Candidato(2, "Luis Torres", "222222", partidoAzul);
        Candidato c3 = new Candidato(3, "María López", "333333", partidoVerde);

        // Mesa de votación (Subject/Observable)
        MesaObservable mesa = new MesaObservable(5, 5, 300, "Colegio Bolívar - Bogotá");

        // ── 2. Crear Observadores ────────────────────────────────────────────
        AutoridadElectoralObserver autoridad = new AutoridadElectoralObserver();
        PartidoPoliticoObserver    verde     = new PartidoPoliticoObserver("Partido Verde");
        AnalistaElectoralObserver  analista  = new AnalistaElectoralObserver("Carlos Pérez");

        // ── 3. Suscribir observadores ────────────────────────────────────────
        System.out.println("\n--- Suscribiendo observadores ---");
        mesa.suscribir(autoridad);
        mesa.suscribir(verde);
        mesa.suscribir(analista);

        // ── 4. Construir el Acta con entidades reales ──────────────────────
        // Necesitamos una Mesa real para el Acta (usamos la misma del observable)
        Municipio bogota = new Municipio(1, "Bogotá", null);
        PuestoDeVotacion puesto = new PuestoDeVotacion(1, "Colegio Bolívar", "Cra 7 #45-10", bogota);
        Mesa mesaReal = new Mesa(5, 5, 300, puesto);

        Acta acta = new Acta(101, mesaReal, LocalDateTime.now());

        // Agregar resultados
        acta.getResultados().add(new ResultadoCandidato(1, c1, 120, acta));
        acta.getResultados().add(new ResultadoCandidato(2, c2,  95, acta));
        acta.getResultados().add(new ResultadoCandidato(3, c3,  80, acta));

        // ── 5. Publicar el Acta → notifica automáticamente a todos ─────────
        mesa.publicarActa(acta);

        // ── 6. Publicar segunda Acta con una reclamación ───────────────────
        Mesa mesaReal2 = new Mesa(8, 8, 250, puesto);
        Acta acta2 = new Acta(102, mesaReal2, LocalDateTime.now());
        acta2.getResultados().add(new ResultadoCandidato(4, c1,   0, acta2));
        acta2.getResultados().add(new ResultadoCandidato(5, c2, 200, acta2));

        Reclamacion rec = new Reclamacion(1,
                "0 votos para Ana Ruiz en mesa con 250 votantes",
                "Partido Verde", acta2, "PENDIENTE");
        acta2.getReclamaciones().add(rec);

        MesaObservable mesa2 = new MesaObservable(8, 8, 250, "Colegio Bolívar - Bogotá");
        mesa2.suscribir(autoridad);
        mesa2.suscribir(verde);
        mesa2.suscribir(analista);
        mesa2.publicarActa(acta2);

        // ── 7. Reporte consolidado ─────────────────────────────────────────
        autoridad.imprimirReporteConsolidado();

        System.out.println("\n--- Alertas del Partido Verde ---");
        List<String> alertas = verde.getAlertas();
        if (alertas.isEmpty()) {
            System.out.println("Sin alertas.");
        } else {
            alertas.forEach(a -> System.out.println("  • " + a));
        }
    }
}
