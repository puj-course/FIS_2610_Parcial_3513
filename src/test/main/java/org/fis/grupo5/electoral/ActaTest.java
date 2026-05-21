package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para el modelo Acta.
 */
class ActaTest {
    private Candidato cand1;
    private Candidato cand2;
    private Acta acta;

    @BeforeEach
    void setUp() {
        cand1 = new Candidato("101", "Valeria GÃ³mez", "Partido del Futuro");
        cand2 = new Candidato("102", "Juan PÃ©rez", "UniÃ³n DemocrÃ¡tica");
        acta = new Acta("ACTA-01", "MESA-05", LocalDate.now());
    }

    @Test
    void testConstructorExitoso() {
        assertEquals("ACTA-01", acta.getId());
        assertEquals("MESA-05", acta.getMesaId());
        assertNotNull(acta.getFecha());
        assertTrue(acta.getResultados().isEmpty());
    }

    @Test
    void testConstructorConDatosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Acta(null, "MESA-05", LocalDate.now()));
        assertThrows(IllegalArgumentException.class, () -> new Acta("A01", "   ", LocalDate.now()));
        assertThrows(IllegalArgumentException.class, () -> new Acta("A01", "MESA-05", null));
    }

    @Test
    void testAgregarResultadoExitoso() {
        acta.agregarResultado(cand1, 150);
        acta.agregarResultado(cand2, 85);

        Map<Candidato, Integer> resultados = acta.getResultados();
        assertEquals(150, resultados.get(cand1));
        assertEquals(85, resultados.get(cand2));
    }

    @Test
    void testAgregarResultadoNegativoVotosNegativos() {
        assertThrows(IllegalArgumentException.class, () -> acta.agregarResultado(cand1, -10));
    }

    @Test
    void testAgregarResultadoNegativoCandidatoNulo() {
        assertThrows(IllegalArgumentException.class, () -> acta.agregarResultado(null, 10));
    }

    @Test
    void testAgregarResultadoCasoLimiteCeroVotos() {
        acta.agregarResultado(cand1, 0);
        assertEquals(0, acta.getResultados().get(cand1));
    }

    @Test
    void testGetTotalVotosVariosResultados() {
        acta.agregarResultado(cand1, 200);
        acta.agregarResultado(cand2, 350);
        assertEquals(550, acta.getTotalVotos());
    }

    @Test
    void testGetTotalVotosCasoLimiteVacio() {
        assertEquals(0, acta.getTotalVotos());
    }

    @Test
    void testGetResultadosInmutable() {
        acta.agregarResultado(cand1, 10);
        Map<Candidato, Integer> resultados = acta.getResultados();
        assertThrows(UnsupportedOperationException.class, () -> resultados.put(cand2, 50));
    }
}
