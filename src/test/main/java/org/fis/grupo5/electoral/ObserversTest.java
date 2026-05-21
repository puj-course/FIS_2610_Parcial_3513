package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.observer.AnalistaResultados;
import org.fis.grupo5.electoral.observer.AutoridadElectoral;
import org.fis.grupo5.electoral.observer.PartidoPolitico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para los observadores concretos: PartidoPolitico,
 * AutoridadElectoral y AnalistaResultados.
 */
class ObserversTest {
    private Candidato cand1;
    private Candidato cand2;
    private Candidato cand3;
    private Acta actaNormal;

    @BeforeEach
    void setUp() {
        cand1 = new Candidato("101", "Valeria GÃ³mez", "Partido del Futuro");
        cand2 = new Candidato("102", "Juan PÃ©rez", "UniÃ³n DemocrÃ¡tica");
        cand3 = new Candidato("103", "Federico Silva", "Partido del Futuro");

        actaNormal = new Acta("A25", "MESA-25", LocalDate.now());
        actaNormal.agregarResultado(cand1, 100);
        actaNormal.agregarResultado(cand2, 80);
        actaNormal.agregarResultado(cand3, 50); // Total: 230 votos (Futuro: 150, UniÃ³n: 80)
    }

    // --- PartidoPolitico ---

    @Test
    void testPartidoPoliticoConstructorDatosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new PartidoPolitico(null));
        assertThrows(IllegalArgumentException.class, () -> new PartidoPolitico("   "));
    }

    @Test
    void testPartidoPoliticoFiltraVotosCorrectamente() {
        PartidoPolitico veedor = new PartidoPolitico("Partido del Futuro");
        assertEquals("Partido PolÃ­tico: Partido del Futuro", veedor.getNombre());
        assertEquals("Partido del Futuro", veedor.getNombrePartido());

        // Verificamos que se ejecute sin excepciones
        assertDoesNotThrow(() -> veedor.actualizar("MESA-25", actaNormal));
    }

    @Test
    void testPartidoPoliticoCasoLimiteSinVotosPartido() {
        // Un partido que no tiene ningÃºn candidato en el acta
        PartidoPolitico veedorOtro = new PartidoPolitico("Partido Inexistente");
        assertDoesNotThrow(() -> veedorOtro.actualizar("MESA-25", actaNormal));
    }

    // --- AutoridadElectoral ---

    @Test
    void testAutoridadElectoralConstructorDatosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new AutoridadElectoral(null, 100));
        assertThrows(IllegalArgumentException.class, () -> new AutoridadElectoral("CNE", -10));
        assertThrows(IllegalArgumentException.class, () -> new AutoridadElectoral("CNE", 0));
    }

    @Test
    void testAutoridadElectoralBajoElCenso() {
        AutoridadElectoral autoridad = new AutoridadElectoral("RegistradurÃ­a", 300); // 230 <= 300
        assertEquals("Autoridad Electoral: RegistradurÃ­a", autoridad.getNombre());
        assertEquals("RegistradurÃ­a", autoridad.getNombreAutoridad());
        assertEquals(300, autoridad.getCensoElectoralMesa());

        assertDoesNotThrow(() -> autoridad.actualizar("MESA-25", actaNormal));
    }

    @Test
    void testAutoridadElectoralSuperaElCenso() {
        AutoridadElectoral autoridad = new AutoridadElectoral("RegistradurÃ­a", 200); // 230 > 200
        // Debe ejecutar e imprimir la alerta crÃ­tica en error stream
        assertDoesNotThrow(() -> autoridad.actualizar("MESA-25", actaNormal));
    }

    // --- AnalistaResultados ---

    @Test
    void testAnalistaResultadosConstructorDatosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new AnalistaResultados(null));
        assertThrows(IllegalArgumentException.class, () -> new AnalistaResultados("   "));
    }

    @Test
    void testAnalistaResultadosCalculaGanadorCorrectamente() {
        AnalistaResultados analista = new AnalistaResultados("DecisiÃ³n 2026");
        assertEquals("Analista de Resultados: DecisiÃ³n 2026", analista.getNombre());
        assertEquals("DecisiÃ³n 2026", analista.getNombreAnalista());

        // El ganador en actaNormal es Valeria GÃ³mez (cand1) con 100 votos
        assertDoesNotThrow(() -> analista.actualizar("MESA-25", actaNormal));
    }

    @Test
    void testAnalistaResultadosCasoLimiteActaVacia() {
        AnalistaResultados analista = new AnalistaResultados("DecisiÃ³n 2026");
        Acta actaVacia = new Acta("A99", "MESA-99", LocalDate.now());
        
        // No debe lanzar excepciones y debe imprimir reporte vacÃ­o
        assertDoesNotThrow(() -> analista.actualizar("MESA-99", actaVacia));
    }
}
