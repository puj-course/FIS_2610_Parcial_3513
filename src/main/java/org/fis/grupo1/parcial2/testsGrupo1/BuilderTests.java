package org.fis.grupo1.parcial2.testsGrupo1;

import org.fis.grupo1.parcial2.Departamento;
import org.fis.grupo1.parcial2.builder.DepartamentoBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTests {

    @Test
    void buildDepartamentoConCodigo() {
        Departamento d = new DepartamentoBuilder()
                .setCodigo("05")
                .build();

        assertNotNull(d);
        assertEquals("05", d.getCodigo());
        assertTrue(d.getMunicipios().isEmpty());
    }

    @Test
    void buildDepartamentoSinCodigo() {
        Departamento d = new DepartamentoBuilder().build();

        assertNotNull(d);
        assertNull(d.getCodigo());
        assertTrue(d.getMunicipios().isEmpty());
    }
}
