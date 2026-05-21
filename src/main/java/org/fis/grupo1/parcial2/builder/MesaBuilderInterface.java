package org.fis.grupo1.parcial2.builder;

import org.fis.grupo1.Mesa;

public interface MesaBuilderInterface {
    void buildIdMesa();
    void buildVotos();
    void buildJurados();
    Mesa getResult();
}