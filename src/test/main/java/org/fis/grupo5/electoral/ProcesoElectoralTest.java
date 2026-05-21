package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.modelo.Jurado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias y de integraciÃ³n para la clase de contexto ProcesoElectoral.
 * Sigue los lineamientos del parcial: mÃ­nimo 2 pruebas por mÃ©todo,
 * incluyendo positivas, negativas y casos de borde.
 */
class ProcesoElectoralTest {
    private ProcesoElectoral proceso;
    private Candidato cand1;
    private Candidato cand2;
    private Jurado jurado1;
    private Acta actaMesa1;

    @BeforeEach
    void setUp() {
        proceso = new ProcesoElectoral(
                "Elecciones Legislativas 2026",
                "Senado y CÃ¡mara",
                LocalDate.of(2026, 3, 8)
        );

        cand1 = new Candidato("101", "Valeria GÃ³mez", "Partido del Futuro");
        cand2 = new Candidato("102", "Juan PÃ©rez", "UniÃ³n DemocrÃ¡tica");
        jurado1 = new Jurado("J01", "Sarah Barrero", "Presidente");

        actaMesa1 = new Acta("A01", "MESA-1", LocalDate.of(2026, 3, 8));
        actaMesa1.agregarResultado(cand1, 100);
        actaMesa1.agregarResultado(cand2, 50);
    }

    // --- Constructor ---

    @Test
    void testConstructorExitoso() {
        assertEquals("Elecciones Legislativas 2026", proceso.getNombre());
        assertEquals("Senado y CÃ¡mara", proceso.getTipoEleccion());
        assertEquals(LocalDate.of(2026, 3, 8), proceso.getFecha());
        assertEquals("Programado", proceso.getEstadoActual().getNombre());
        assertTrue(proceso.getCandidatos().isEmpty());
        assertTrue(proceso.getJurados().isEmpty());
        assertTrue(proceso.getActas().isEmpty());
    }

    @Test
    void testConstructorConDatosInvalidos() {
        // Negativo: Nombre vacÃ­o
        assertThrows(IllegalArgumentException.class, () -> 
                new ProcesoElectoral("   ", "Senado", LocalDate.now()));
        // Negativo: Tipo elecciÃ³n nulo
        assertThrows(IllegalArgumentException.class, () -> 
                new ProcesoElectoral("Elecciones", null, LocalDate.now()));
        // Negativo: Fecha nula
        assertThrows(IllegalArgumentException.class, () -> 
                new ProcesoElectoral("Elecciones", "Senado", null));
    }

    // --- inscribirCandidato() ---

    @Test
    void testInscribirCandidatoFlujoCompleto() {
        proceso.avanzarEstado(); // Entra a InscripciÃ³n
        
        // Positivo: Inscribir candidato exitosamente
        assertDoesNotThrow(() -> proceso.inscribirCandidato(cand1));
        assertEquals(1, proceso.getCandidatos().size());
        assertTrue(proceso.getCandidatos().contains(cand1));
    }

    @Test
    void testInscribirCandidatoNegativoCandidatoDuplicado() {
        proceso.avanzarEstado(); // Entra a InscripciÃ³n
        proceso.inscribirCandidato(cand1);

        // Negativo: Lanzar excepciÃ³n al inscribir el mismo candidato dos veces
        assertThrows(IllegalArgumentException.class, () -> proceso.inscribirCandidato(cand1));
    }

    @Test
    void testInscribirCandidatoNegativoEstadoIncorrecto() {
        // Negativo: Intentar inscribir en estado Programado
        assertThrows(IllegalStateException.class, () -> proceso.inscribirCandidato(cand1));
    }

    @Test
    void testInscribirCandidatoCasoLimiteNulo() {
        proceso.avanzarEstado(); // Entra a InscripciÃ³n
        
        // Borde/Negativo: Candidato nulo lanza excepciÃ³n
        assertThrows(IllegalArgumentException.class, () -> proceso.inscribirCandidato(null));
    }

    // --- asignarJurado() ---

    @Test
    void testAsignarJuradoExitoso() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n

        // Positivo: Asignar jurado en estado VotaciÃ³n
        assertDoesNotThrow(() -> proceso.asignarJurado(jurado1));
        assertEquals(1, proceso.getJurados().size());
        assertTrue(proceso.getJurados().contains(jurado1));
    }

    @Test
    void testAsignarJuradoDuplicado() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n
        proceso.asignarJurado(jurado1);

        // Negativo: Lanzar excepciÃ³n si ya estÃ¡ asignado
        assertThrows(IllegalArgumentException.class, () -> proceso.asignarJurado(jurado1));
    }

    @Test
    void testAsignarJuradoCasoLimiteNulo() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n

        // Borde/Negativo: Jurado nulo lanza excepciÃ³n
        assertThrows(IllegalArgumentException.class, () -> proceso.asignarJurado(null));
    }

    // --- registrarActa() ---

    @Test
    void testRegistrarActaExitoso() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n

        // Positivo: Registrar acta en estado VotaciÃ³n
        assertDoesNotThrow(() -> proceso.registrarActa(actaMesa1));
        assertEquals(1, proceso.getActas().size());
        assertTrue(proceso.getActas().contains(actaMesa1));
    }

    @Test
    void testRegistrarActaDuplicadaOMismaMesa() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n
        proceso.registrarActa(actaMesa1);

        // Negativo: Duplicada con mismo ID
        Acta actaDuplicadaId = new Acta("A01", "MESA-2", LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> proceso.registrarActa(actaDuplicadaId));

        // Negativo: Diferente ID pero misma mesa
        Acta actaMismaMesa = new Acta("A02", "MESA-1", LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> proceso.registrarActa(actaMismaMesa));
    }

    @Test
    void testRegistrarActaCasoLimiteNulo() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n

        assertThrows(IllegalArgumentException.class, () -> proceso.registrarActa(null));
    }

    // --- consultarResultados() ---

    @Test
    void testConsultarResultadosFlujoEscrutinio() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.inscribirCandidato(cand1);
        proceso.inscribirCandidato(cand2);

        proceso.avanzarEstado(); // VotaciÃ³n
        proceso.registrarActa(actaMesa1);

        proceso.avanzarEstado(); // Escrutinio

        // Positivo: Consolidar y retornar reporte correcto
        String reporte = proceso.consultarResultados();
        assertNotNull(reporte);
        assertTrue(reporte.contains("Valeria GÃ³mez"));
        assertTrue(reporte.contains("100"));
        assertTrue(reporte.contains("Juan PÃ©rez"));
        assertTrue(reporte.contains("50"));
        assertTrue(reporte.contains("Total Votos Escrutados: 150"));
    }

    @Test
    void testConsultarResultadosCasoLimiteSinActas() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n
        proceso.avanzarEstado(); // Escrutinio

        // Borde: Sin actas debe retornar mensaje informando vacÃ­o
        String reporte = proceso.consultarResultados();
        assertEquals("Sin resultados: No hay actas registradas.", reporte);
    }

    @Test
    void testConsultarResultadosCasoLimiteActasSinVotos() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.inscribirCandidato(cand1);

        proceso.avanzarEstado(); // VotaciÃ³n
        Acta actaVacia = new Acta("A99", "MESA-99", LocalDate.now()); // sin agregar resultados
        proceso.registrarActa(actaVacia);

        proceso.avanzarEstado(); // Escrutinio

        String reporte = proceso.consultarResultados();
        assertEquals("Sin resultados: Las actas registradas no contienen votos.", reporte);
    }

    // --- avanzarEstado() ---

    @Test
    void testAvanzarEstadoSecuenciaCompleta() {
        // Positivo: Secuencia normal de estados
        assertEquals("Programado", proceso.getEstadoActual().getNombre());
        
        proceso.avanzarEstado();
        assertEquals("InscripciÃ³n", proceso.getEstadoActual().getNombre());
        
        proceso.avanzarEstado();
        assertEquals("VotaciÃ³n", proceso.getEstadoActual().getNombre());
        
        proceso.avanzarEstado();
        assertEquals("Escrutinio", proceso.getEstadoActual().getNombre());
        
        proceso.avanzarEstado();
        assertEquals("Finalizado", proceso.getEstadoActual().getNombre());
    }

    @Test
    void testAvanzarEstadoNegativoSuperaFinalizado() {
        proceso.avanzarEstado(); // InscripciÃ³n
        proceso.avanzarEstado(); // VotaciÃ³n
        proceso.avanzarEstado(); // Escrutinio
        proceso.avanzarEstado(); // Finalizado

        // Negativo: Avanzar mÃ¡s allÃ¡ de Finalizado debe lanzar excepciÃ³n
        assertThrows(IllegalStateException.class, () -> proceso.avanzarEstado());
    }
}
