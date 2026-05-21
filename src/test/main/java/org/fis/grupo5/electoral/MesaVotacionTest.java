package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.observer.ObservadorProceso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase de sujeto MesaVotacion.
 */
class MesaVotacionTest {
    private MesaVotacion mesa;
    private ObservadorProceso dummyObserver;
    private Acta actaValida;

    @BeforeEach
    void setUp() {
        mesa = new MesaVotacion("MESA-99");
        actaValida = new Acta("A99", "MESA-99", LocalDate.now());
        
        dummyObserver = new ObservadorProceso() {
            @Override
            public void actualizar(String mesaId, Acta acta) {}

            @Override
            public String getNombre() {
                return "DummyObserver";
            }
        };
    }

    // --- Constructor ---

    @Test
    void testConstructorExitoso() {
        assertEquals("MESA-99", mesa.getId());
        assertTrue(mesa.getObservadores().isEmpty());
        assertNull(mesa.getActaActual());
    }

    @Test
    void testConstructorConDatosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new MesaVotacion(null));
        assertThrows(IllegalArgumentException.class, () -> new MesaVotacion("   "));
    }

    // --- registrarObservador() ---

    @Test
    void testRegistrarObservadorExitoso() {
        assertDoesNotThrow(() -> mesa.registrarObservador(dummyObserver));
        assertEquals(1, mesa.getObservadores().size());
        assertTrue(mesa.getObservadores().contains(dummyObserver));
    }

    @Test
    void testRegistrarObservadorDuplicado() {
        mesa.registrarObservador(dummyObserver);
        assertThrows(IllegalArgumentException.class, () -> mesa.registrarObservador(dummyObserver));
    }

    @Test
    void testRegistrarObservadorNulo() {
        assertThrows(IllegalArgumentException.class, () -> mesa.registrarObservador(null));
    }

    // --- removerObservador() ---

    @Test
    void testRemoverObservadorExitoso() {
        mesa.registrarObservador(dummyObserver);
        assertDoesNotThrow(() -> mesa.removerObservador(dummyObserver));
        assertTrue(mesa.getObservadores().isEmpty());
    }

    @Test
    void testRemoverObservadorNoRegistrado() {
        assertThrows(IllegalArgumentException.class, () -> mesa.removerObservador(dummyObserver));
    }

    @Test
    void testRemoverObservadorNulo() {
        assertThrows(IllegalArgumentException.class, () -> mesa.removerObservador(null));
    }

    // --- registrarActa() ---

    @Test
    void testRegistrarActaExitoso() {
        assertDoesNotThrow(() -> mesa.registrarActa(actaValida));
        assertEquals(actaValida, mesa.getActaActual());
    }

    @Test
    void testRegistrarActaMesaErronea() {
        Acta actaMesaIncorrecta = new Acta("A99", "MESA-OTRA", LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> mesa.registrarActa(actaMesaIncorrecta));
    }

    @Test
    void testRegistrarActaNulo() {
        assertThrows(IllegalArgumentException.class, () -> mesa.registrarActa(null));
    }

    // --- notificarObservadores() ---

    @Test
    void testNotificarObservadoresDisparaActualizacion() {
        AtomicBoolean fueActualizado = new AtomicBoolean(false);
        ObservadorProceso testObserver = new ObservadorProceso() {
            @Override
            public void actualizar(String mesaId, Acta acta) {
                assertEquals("MESA-99", mesaId);
                assertEquals(actaValida, acta);
                fueActualizado.set(true);
            }

            @Override
            public String getNombre() {
                return "TestObserver";
            }
        };

        mesa.registrarObservador(testObserver);
        mesa.registrarActa(actaValida);

        assertTrue(fueActualizado.get(), "El observador no fue notificado correctamente al registrar el acta.");
    }
}
