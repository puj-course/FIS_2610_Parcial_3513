package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas Unitarias — Patrón Observer (Sistema Electoral Grupo 5)
 * ================================================================
 * Usa las entidades reales del dominio: Acta, Mesa, Candidato,
 * PartidoPolitico, Reclamacion, ResultadoCandidato.
 * Al menos 2 pruebas por método (normal + negativa/límite).
 */
class MesaObservableObserverTest {

    private MesaObservable mesa;
    private AutoridadElectoralObserver autoridad;
    private PartidoPoliticoObserver partido;
    private AnalistaElectoralObserver analista;

    // Entidades de dominio reutilizables
    private PartidoPolitico partidoVerde;
    private Candidato candidatoUno;
    private Candidato candidatoDos;
    private Mesa mesaReal;

    @BeforeEach
    void setUp() {
        mesa      = new MesaObservable(1, 1, 200, "Puesto Test");
        autoridad = new AutoridadElectoralObserver();
        partido   = new PartidoPoliticoObserver("Partido Verde");
        analista  = new AnalistaElectoralObserver("Ana Gómez");

        partidoVerde  = new PartidoPolitico(1, "Partido Verde");
        Municipio mun = new Municipio(1, "Bogotá", null);
        PuestoDeVotacion puesto = new PuestoDeVotacion(1, "Colegio Test", "Calle 1", mun);
        mesaReal      = new Mesa(1, 1, 200, puesto);
        candidatoUno  = new Candidato(1, "Candidato Uno", "111", partidoVerde);
        candidatoDos  = new Candidato(2, "Candidato Dos", "222",
                            new PartidoPolitico(2, "Partido Azul"));
    }

    // ── Helper ────────────────────────────────────────────────────────────

    private Acta crearActaSimple(int idActa, int votosC1, int votosC2) {
        Acta acta = new Acta(idActa, mesaReal, LocalDateTime.now());
        acta.getResultados().add(new ResultadoCandidato(1, candidatoUno, votosC1, acta));
        acta.getResultados().add(new ResultadoCandidato(2, candidatoDos, votosC2, acta));
        return acta;
    }

    // ── PRUEBAS: suscribir() ─────────────────────────────────────────────

    /** Normal: observador suscrito recibe el Acta */
    @Test
    void testSuscribirObservadorRecibeActa() {
        mesa.suscribir(autoridad);
        mesa.publicarActa(crearActaSimple(1, 100, 80));
        assertEquals(1, autoridad.getActasConsolidadas().size());
    }

    /** Límite: suscribir doble → notificado dos veces */
    @Test
    void testSuscribirDobleVecesNotificaDosVeces() {
        mesa.suscribir(autoridad);
        mesa.suscribir(autoridad);
        mesa.publicarActa(crearActaSimple(2, 50, 60));
        assertEquals(2, autoridad.getActasConsolidadas().size());
    }

    // ── PRUEBAS: desuscribir() ────────────────────────────────────────────

    /** Normal: desuscrito NO recibe el Acta */
    @Test
    void testDesuscribirObservadorNoRecibeActa() {
        mesa.suscribir(autoridad);
        mesa.desuscribir(autoridad);
        mesa.publicarActa(crearActaSimple(3, 70, 30));
        assertTrue(autoridad.getActasConsolidadas().isEmpty());
    }

    /** Negativa: desuscribir observador no suscrito no lanza excepción */
    @Test
    void testDesuscribirNoSuscritoNoLanzaExcepcion() {
        assertDoesNotThrow(() -> mesa.desuscribir(autoridad));
    }

    // ── PRUEBAS: publicarActa() ───────────────────────────────────────────

    /** Normal: el Acta publicada se guarda como ultimaActa */
    @Test
    void testPublicarActaGuardaUltimaActa() {
        mesa.suscribir(autoridad);
        Acta acta = crearActaSimple(10, 120, 90);
        mesa.publicarActa(acta);
        assertNotNull(mesa.getUltimaActa());
        assertEquals(10, mesa.getUltimaActa().getId());
    }

    /** Límite: Acta con lista de resultados vacía no lanza excepción */
    @Test
    void testPublicarActaConResultadosVaciosNoLanzaExcepcion() {
        mesa.suscribir(autoridad);
        Acta actaVacia = new Acta(99, mesaReal, LocalDateTime.now());
        assertDoesNotThrow(() -> mesa.publicarActa(actaVacia));
        assertEquals(0, autoridad.getTotalVotosNacionales());
    }

    // ── PRUEBAS: AutoridadElectoralObserver ───────────────────────────────

    /** Normal: suma correctamente los votos de dos actas */
    @Test
    void testAutoridadAcumulaVotos() {
        mesa.suscribir(autoridad);
        mesa.publicarActa(crearActaSimple(1, 100, 80));  // 180
        mesa.publicarActa(crearActaSimple(2,  50, 70));  // 120
        assertEquals(300, autoridad.getTotalVotosNacionales());
        assertEquals(2, autoridad.getActasConsolidadas().size());
    }

    /** Negativa: sin actas, totales en cero */
    @Test
    void testAutoridadSinActasTotalesEnCero() {
        assertEquals(0, autoridad.getTotalVotosNacionales());
        assertTrue(autoridad.getActasConsolidadas().isEmpty());
    }

    // ── PRUEBAS: PartidoPoliticoObserver ──────────────────────────────────

    /** Normal: partido acumula votos de su candidato */
    @Test
    void testPartidoAcumulaVotosDeSuCandidato() {
        mesa.suscribir(partido);
        mesa.publicarActa(crearActaSimple(1, 120, 80));
        // candidatoUno pertenece a Partido Verde → 120 votos
        assertEquals(120, partido.getTotalVotosObtenidos());
    }

    /** Negativa: partido recibe alerta si hay reclamación en el Acta */
    @Test
    void testPartidoRegistraAlertaCuandoHayReclamacion() {
        mesa.suscribir(partido);
        Acta acta = crearActaSimple(5, 0, 200);
        Reclamacion rec = new Reclamacion(1,
                "Resultado sospechoso", "Partido Verde", acta, "PENDIENTE");
        acta.getReclamaciones().add(rec);
        mesa.publicarActa(acta);
        assertFalse(partido.getAlertas().isEmpty());
        assertTrue(partido.getAlertas().get(0).contains("Resultado sospechoso"));
    }

    // ── PRUEBAS: AnalistaElectoralObserver ───────────────────────────────

    /** Normal: analista incrementa contador por cada Acta recibida */
    @Test
    void testAnalistaIncrementaContador() {
        mesa.suscribir(analista);
        mesa.publicarActa(crearActaSimple(1, 80, 60));
        assertEquals(1, analista.getTotalActasAnalizadas());
        mesa.publicarActa(crearActaSimple(2, 40, 30));
        assertEquals(2, analista.getTotalActasAnalizadas());
    }

    /** Límite: analista inicia con 0 actas analizadas */
    @Test
    void testAnalistaIniciaCeroActas() {
        assertEquals(0, analista.getTotalActasAnalizadas());
    }
}
