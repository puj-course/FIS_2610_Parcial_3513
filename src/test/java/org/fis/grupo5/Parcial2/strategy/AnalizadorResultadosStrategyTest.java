package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas Unitarias — Patrón Strategy (Sistema Electoral Grupo 5)
 * ================================================================
 * Verifica que el Contexto (AnalizadorResultados) cambia de
 * estrategia correctamente y que cada Estrategia concreta
 * ordena los resultados como se espera.
 */
class AnalizadorResultadosStrategyTest {

    private Acta acta;
    private AnalizadorResultados analizador;

    // Entidades para las pruebas
    private Candidato cAna, cLuis, cMaria, cPedro;
    private PartidoPolitico verde, azul;

    @BeforeEach
    void setUp() {
        verde = new PartidoPolitico(1, "Partido Verde");
        azul  = new PartidoPolitico(2, "Partido Azul");

        cAna   = new Candidato(1, "Ana Ruiz",    "101", verde);
        cLuis  = new Candidato(2, "Luis Torres", "202", azul);
        cMaria = new Candidato(3, "María López", "303", verde);
        cPedro = new Candidato(4, "Pedro Gómez", "404", null); // Sin partido

        Municipio bogota = new Municipio(1, "Bogotá", null);
        PuestoDeVotacion puesto = new PuestoDeVotacion(1, "Test", "Test", bogota);
        Mesa mesa = new Mesa(1, 1, 500, puesto);

        acta = new Acta(100, mesa, LocalDateTime.now());
        // Agregamos resultados desordenados
        acta.getResultados().add(new ResultadoCandidato(1, cAna,   50, acta));
        acta.getResultados().add(new ResultadoCandidato(2, cLuis, 150, acta));
        acta.getResultados().add(new ResultadoCandidato(3, cMaria, 20, acta));
        acta.getResultados().add(new ResultadoCandidato(4, cPedro, 80, acta));
        // Total votos = 300
    }

    // ── PRUEBAS: Contexto (AnalizadorResultados) ──────────────────────────

    @Test
    void testContextoIniciaConEstrategiaAsignada() {
        analizador = new AnalizadorResultados(new OrdenarPorVotosStrategy());
        assertNotNull(analizador.getEstrategia());
        assertEquals("Ordenar por Votos (mayor a menor)",
                analizador.getEstrategia().getNombreEstrategia());
    }

    @Test
    void testContextoPuedeCambiarEstrategiaEnCaliente() {
        analizador = new AnalizadorResultados(new OrdenarPorVotosStrategy());
        analizador.setEstrategia(new OrdenarPorPartidoStrategy());

        assertEquals("Ordenar por Partido Político (alfabético) y Votos",
                analizador.getEstrategia().getNombreEstrategia());
    }

    // ── PRUEBAS: OrdenarPorVotosStrategy ──────────────────────────────────

    @Test
    void testOrdenarPorVotosDeMayorAMenor() {
        analizador = new AnalizadorResultados(new OrdenarPorVotosStrategy());
        List<ResultadoCandidato> resultados = analizador.analizar(acta);

        // El orden esperado por votos (150, 80, 50, 20)
        assertEquals(cLuis,  resultados.get(0).getCandidato());
        assertEquals(cPedro, resultados.get(1).getCandidato());
        assertEquals(cAna,   resultados.get(2).getCandidato());
        assertEquals(cMaria, resultados.get(3).getCandidato());
    }

    @Test
    void testOrdenarPorVotosConActaVaciaRetornaListaVacia() {
        Acta actaVacia = new Acta(101, acta.getMesa(), LocalDateTime.now());
        analizador = new AnalizadorResultados(new OrdenarPorVotosStrategy());
        List<ResultadoCandidato> resultados = analizador.analizar(actaVacia);
        assertTrue(resultados.isEmpty());
    }

    // ── PRUEBAS: OrdenarPorPorcentajeStrategy ─────────────────────────────

    @Test
    void testOrdenarPorPorcentajeDeMayorAMenor() {
        analizador = new AnalizadorResultados(new OrdenarPorPorcentajeStrategy());
        List<ResultadoCandidato> resultados = analizador.analizar(acta);

        // Luis (150/300 = 50%), Pedro (80/300 = 26.6%), Ana (16.6%), Maria (6.6%)
        assertEquals(cLuis,  resultados.get(0).getCandidato());
        assertEquals(cPedro, resultados.get(1).getCandidato());
        assertEquals(cAna,   resultados.get(2).getCandidato());
        assertEquals(cMaria, resultados.get(3).getCandidato());
    }

    @Test
    void testCalcularPorcentajeCorrecto() {
        OrdenarPorPorcentajeStrategy estrategia = new OrdenarPorPorcentajeStrategy();
        // Ana tiene 50 votos de 300 totales -> 16.666... %
        double pctAna = estrategia.calcularPorcentaje(acta.getResultados().get(0), acta);
        assertEquals(16.66, pctAna, 0.1);

        // Luis tiene 150 votos de 300 totales -> 50.0 %
        double pctLuis = estrategia.calcularPorcentaje(acta.getResultados().get(1), acta);
        assertEquals(50.0, pctLuis, 0.01);
    }

    // ── PRUEBAS: OrdenarPorPartidoStrategy ────────────────────────────────

    @Test
    void testOrdenarPorPartidoYVotos() {
        analizador = new AnalizadorResultados(new OrdenarPorPartidoStrategy());
        List<ResultadoCandidato> resultados = analizador.analizar(acta);

        // Orden esperado alfabético: Partido Azul, Partido Verde, Sin Partido (null)
        // Dentro del Verde (Ana 50, Maria 20)
        assertEquals("Partido Azul", resultados.get(0).getCandidato().getPartido().getNombre());
        assertEquals(cLuis, resultados.get(0).getCandidato());

        assertEquals("Partido Verde", resultados.get(1).getCandidato().getPartido().getNombre());
        assertEquals(cAna, resultados.get(1).getCandidato()); // 50 votos (primero en el Verde)

        assertEquals("Partido Verde", resultados.get(2).getCandidato().getPartido().getNombre());
        assertEquals(cMaria, resultados.get(2).getCandidato()); // 20 votos

        assertNull(resultados.get(3).getCandidato().getPartido()); // Pedro no tiene partido ("ZZZ_SIN_PARTIDO")
        assertEquals(cPedro, resultados.get(3).getCandidato());
    }
}
