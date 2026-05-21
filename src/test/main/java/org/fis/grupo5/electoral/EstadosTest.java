package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.estado.*;
import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para validar las operaciones y transiciones
 * de cada estado concreto del patrÃ³n State.
 */
class EstadosTest {
    private ProcesoElectoral proceso;
    private Candidato candidato;
    private Jurado jurado;
    private Acta acta;

    @BeforeEach
    void setUp() {
        proceso = new ProcesoElectoral("Elecciones 2026", "Senado", LocalDate.now());
        candidato = new Candidato("201", "Candidato X", "Partido X");
        jurado = new Jurado("J201", "Jurado X", "Vocal");
        acta = new Acta("ACTA-X", "MESA-X", LocalDate.now());
        acta.agregarResultado(candidato, 100);
    }

    // --- EstadoProgramado ---

    @Test
    void testEstadoProgramadoBloqueaTodo() {
        EstadoProceso programado = new EstadoProgramado();
        proceso.setEstadoActualInternal(programado);

        assertThrows(IllegalStateException.class, () -> programado.inscribirCandidato(proceso, candidato));
        assertThrows(IllegalStateException.class, () -> programado.asignarJurado(proceso, jurado));
        assertThrows(IllegalStateException.class, () -> programado.registrarActa(proceso, acta));
        assertThrows(IllegalStateException.class, () -> programado.consultarResultados(proceso));
    }

    @Test
    void testEstadoProgramadoTransicionSiguiente() {
        EstadoProceso programado = new EstadoProgramado();
        EstadoProceso siguiente = programado.siguiente();
        assertTrue(siguiente instanceof EstadoInscripcion);
        assertEquals("InscripciÃ³n", siguiente.getNombre());
    }

    // --- EstadoInscripcion ---

    @Test
    void testEstadoInscripcionPermiteInscripcion() {
        EstadoProceso inscripcion = new EstadoInscripcion();
        proceso.setEstadoActualInternal(inscripcion);

        assertDoesNotThrow(() -> inscripcion.inscribirCandidato(proceso, candidato));
        assertTrue(proceso.getCandidatos().contains(candidato));
    }

    @Test
    void testEstadoInscripcionBloqueaVotoActaYResultados() {
        EstadoProceso inscripcion = new EstadoInscripcion();
        proceso.setEstadoActualInternal(inscripcion);

        assertThrows(IllegalStateException.class, () -> inscripcion.asignarJurado(proceso, jurado));
        assertThrows(IllegalStateException.class, () -> inscripcion.registrarActa(proceso, acta));
        assertThrows(IllegalStateException.class, () -> inscripcion.consultarResultados(proceso));
    }

    @Test
    void testEstadoInscripcionTransicionSiguiente() {
        EstadoProceso inscripcion = new EstadoInscripcion();
        EstadoProceso siguiente = inscripcion.siguiente();
        assertTrue(siguiente instanceof EstadoVotacion);
        assertEquals("VotaciÃ³n", siguiente.getNombre());
    }

    // --- EstadoVotacion ---

    @Test
    void testEstadoVotacionPermiteJuradoYActa() {
        EstadoProceso votacion = new EstadoVotacion();
        proceso.setEstadoActualInternal(votacion);

        assertDoesNotThrow(() -> votacion.asignarJurado(proceso, jurado));
        assertDoesNotThrow(() -> votacion.registrarActa(proceso, acta));
        assertTrue(proceso.getJurados().contains(jurado));
        assertTrue(proceso.getActas().contains(acta));
    }

    @Test
    void testEstadoVotacionBloqueaInscripcionYResultados() {
        EstadoProceso votacion = new EstadoVotacion();
        proceso.setEstadoActualInternal(votacion);

        assertThrows(IllegalStateException.class, () -> votacion.inscribirCandidato(proceso, candidato));
        assertThrows(IllegalStateException.class, () -> votacion.consultarResultados(proceso));
    }

    @Test
    void testEstadoVotacionTransicionSiguiente() {
        EstadoProceso votacion = new EstadoVotacion();
        EstadoProceso siguiente = votacion.siguiente();
        assertTrue(siguiente instanceof EstadoEscrutinio);
        assertEquals("Escrutinio", siguiente.getNombre());
    }

    // --- EstadoEscrutinio ---

    @Test
    void testEstadoEscrutinioPermiteResultados() {
        EstadoProceso escrutinio = new EstadoEscrutinio();
        proceso.setEstadoActualInternal(escrutinio);
        proceso.addActaInternal(acta); // Acta aÃ±adida previamente para tener datos

        String resultados = assertDoesNotThrow(() -> escrutinio.consultarResultados(proceso));
        assertTrue(resultados.contains("Candidato X"));
        assertTrue(resultados.contains("100"));
    }

    @Test
    void testEstadoEscrutinioBloqueaInscribirAsignarYVotar() {
        EstadoProceso escrutinio = new EstadoEscrutinio();
        proceso.setEstadoActualInternal(escrutinio);

        assertThrows(IllegalStateException.class, () -> escrutinio.inscribirCandidato(proceso, candidato));
        assertThrows(IllegalStateException.class, () -> escrutinio.asignarJurado(proceso, jurado));
        assertThrows(IllegalStateException.class, () -> escrutinio.registrarActa(proceso, acta));
    }

    @Test
    void testEstadoEscrutinioTransicionSiguiente() {
        EstadoProceso escrutinio = new EstadoEscrutinio();
        EstadoProceso siguiente = escrutinio.siguiente();
        assertTrue(siguiente instanceof EstadoFinalizado);
        assertEquals("Finalizado", siguiente.getNombre());
    }

    // --- EstadoFinalizado ---

    @Test
    void testEstadoFinalizadoPermiteResultadosSoloLectura() {
        EstadoProceso finalizado = new EstadoFinalizado();
        proceso.setEstadoActualInternal(finalizado);
        proceso.addActaInternal(acta);

        String resultados = assertDoesNotThrow(() -> finalizado.consultarResultados(proceso));
        assertTrue(resultados.contains("BOLETÃN DE RESULTADOS FINALES"));
        assertTrue(resultados.contains("Candidato X"));
    }

    @Test
    void testEstadoFinalizadoBloqueaTodoLoDemas() {
        EstadoProceso finalizado = new EstadoFinalizado();
        proceso.setEstadoActualInternal(finalizado);

        assertThrows(IllegalStateException.class, () -> finalizado.inscribirCandidato(proceso, candidato));
        assertThrows(IllegalStateException.class, () -> finalizado.asignarJurado(proceso, jurado));
        assertThrows(IllegalStateException.class, () -> finalizado.registrarActa(proceso, acta));
    }

    @Test
    void testEstadoFinalizadoTransicionSiguienteLanzaExcepcion() {
        EstadoProceso finalizado = new EstadoFinalizado();
        assertThrows(IllegalStateException.class, finalizado::siguiente);
    }
}
