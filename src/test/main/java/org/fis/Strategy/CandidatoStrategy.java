package org.fis.grupo3.strategy;

import org.fis.grupo3.model.Candidato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Strategy Pattern - Candidato Validation")
class CandidatoStrategyTest {

    private Candidato candidato;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("ValidarCedulaStrategy - Cédula válida retorna true")
    void testValidarCedulaStrategy_CedulaValida() {
        String cedulaValida = "12345678";
        candidato = new Candidato(cedulaValida, "001");
        CandidatoStrategy strategy = new ValidarCedulaStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertTrue(resultado, "La cédula válida debe retornar true");
    }

    @Test
    @DisplayName("ValidarCedulaStrategy - Cédula nula retorna false")
    void testValidarCedulaStrategy_CedulaNula() {
        candidato = new Candidato(null, "001");
        CandidatoStrategy strategy = new ValidarCedulaStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertFalse(resultado, "La cédula nula debe retornar false");
    }

    @Test
    @DisplayName("ValidarCedulaStrategy - Cédula con caracteres inválidos retorna false")
    void testValidarCedulaStrategy_CedulaInvalida() {
        String cedulaInvalida = "ABC12345";
        candidato = new Candidato(cedulaInvalida, "001");
        CandidatoStrategy strategy = new ValidarCedulaStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertFalse(resultado, "La cédula con caracteres no numéricos debe retornar false");
    }

    @Test
    @DisplayName("ValidarTarjetonStrategy - Tarjetón válido retorna true")
    void testValidarTarjetonStrategy_TarjetonValido() {
        candidato = new Candidato("12345678", "TARJETON001");
        CandidatoStrategy strategy = new ValidarTarjetonStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertTrue(resultado, "El tarjetón válido debe retornar true");
    }

    @Test
    @DisplayName("ValidarTarjetonStrategy - Tarjetón vacío retorna false")
    void testValidarTarjetonStrategy_TarjetonVacio() {
        candidato = new Candidato("12345678", "");
        CandidatoStrategy strategy = new ValidarTarjetonStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertFalse(resultado, "El tarjetón vacío debe retornar false");
    }

    @Test
    @DisplayName("ValidarTarjetonStrategy - Tarjetón nulo retorna false")
    void testValidarTarjetonStrategy_TarjetonNulo() {
        candidato = new Candidato("12345678", null);
        CandidatoStrategy strategy = new ValidarTarjetonStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertFalse(resultado, "El tarjetón nulo debe retornar false");
    }

    @Test
    @DisplayName("ValidacionCompletaStrategy - Candidato válido retorna true")
    void testValidacionCompletaStrategy_CandidatoValido() {
        candidato = new Candidato("12345678", "TARJETON001");
        CandidatoStrategy strategy = new ValidacionCompletaStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertTrue(resultado, "Un candidato con cédula y tarjetón válidos debe retornar true");
    }

    @Test
    @DisplayName("ValidacionCompletaStrategy - Candidato con cédula inválida retorna false")
    void testValidacionCompletaStrategy_CedulaInvalida() {
        candidato = new Candidato("ABC", "TARJETON001");
        CandidatoStrategy strategy = new ValidacionCompletaStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertFalse(resultado, "Un candidato con cédula inválida debe retornar false");
    }

    @Test
    @DisplayName("ValidacionCompletaStrategy - Candidato con tarjetón inválido retorna false")
    void testValidacionCompletaStrategy_TarjetonInvalido() {
        candidato = new Candidato("12345678", "");
        CandidatoStrategy strategy = new ValidacionCompletaStrategy();

        boolean resultado = strategy.ejecutar(candidato);

        assertFalse(resultado, "Un candidato con tarjetón inválido debe retornar false");
    }

    @Test
    @DisplayName("Candidato.processar() - Usa la estrategia asignada")
    void testCandidatoProcessar_EstrategiaAsignada() {
        candidato = new Candidato("12345678", "TARJETON001");
        CandidatoStrategy estrategiaPersonalizada = new ValidarCedulaStrategy();
        candidato.setStrategy(estrategiaPersonalizada);

        boolean resultado = candidato.processar();

        assertTrue(resultado, "El método processar debe usar la estrategia asignada");
    }
}