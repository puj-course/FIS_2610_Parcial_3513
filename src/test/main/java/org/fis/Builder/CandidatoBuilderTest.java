import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests para CandidatoBuilder")
class CandidatoBuilderTest {

    private CandidatoBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new CandidatoBuilder();
    }


    @Test
    @DisplayName("cedula() retorna la misma instancia del builder (fluent API)")
    void cedula_retornaLaMismaInstancia() {
        CandidatoBuilder resultado = builder.cedula("123456");
        assertSame(builder, resultado);
    }

    @Test
    @DisplayName("numeroTarjeton() retorna la misma instancia del builder (fluent API)")
    void numeroTarjeton_retornaLaMismaInstancia() {
        CandidatoBuilder resultado = builder.numeroTarjeton("T-01");
        assertSame(builder, resultado);
    }


    @Nested
    @DisplayName("build() exitoso")
    class BuildExitoso {

        @Test
        @DisplayName("Construye un Candidato con datos válidos")
        void build_datosValidos_retornaCandidato() {
            Candidato candidato = builder
                    .cedula("987654321")
                    .numeroTarjeton("T-05")
                    .build();

            assertNotNull(candidato);
        }

        @Test
        @DisplayName("El Candidato construido conserva la cédula indicada")
        void build_datosValidos_conservaCedula() {
            Candidato candidato = builder
                    .cedula("111222333")
                    .numeroTarjeton("T-10")
                    .build();

            assertEquals("111222333", candidato.getCedula());
        }

        @Test
        @DisplayName("El Candidato construido conserva el número de tarjetón indicado")
        void build_datosValidos_conservaNumeroTarjeton() {
            Candidato candidato = builder
                    .cedula("111222333")
                    .numeroTarjeton("T-10")
                    .build();

            assertEquals("T-10", candidato.getNumeroTarjeton());
        }

        @Test
        @DisplayName("Cédula con un solo dígito es válida")
        void build_cedulaUnDigito_construyeCorrectamente() {
            Candidato candidato = builder
                    .cedula("1")
                    .numeroTarjeton("T-01")
                    .build();

            assertNotNull(candidato);
        }
    }
    
    @Nested
    @DisplayName("Orden de validaciones")
    class OrdenValidaciones {

        @Test
        @DisplayName("La validación de cédula nula precede a la de tarjetón nulo")
        void build_cedulaYTarjetonNulos_primeroValidaCedula() {
            // ningún campo seteado
            IllegalStateException ex = assertThrows(
                    IllegalStateException.class,
                    () -> builder.build()
            );
            assertEquals("La cédula es obligatoria.", ex.getMessage());
        }

        @Test
        @DisplayName("La validación de formato de cédula precede a la de tarjetón nulo")
        void build_cedulaInvalidaYTarjetonNulo_primeroValidaFormatoCedula() {
            builder.cedula("abc");   // sin setear tarjetón

            IllegalStateException ex = assertThrows(
                    IllegalStateException.class,
                    () -> builder.build()
            );
            assertEquals("La cédula solo debe contener números.", ex.getMessage());
        }
    }
}