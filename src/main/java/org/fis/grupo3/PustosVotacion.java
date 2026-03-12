package org.fis.grupo3;

import java.util.*;

public class PustosVotacion {
    private Jurado jurados;
    private List<String> resultados;

    public PustosVotacion(Jurado jurados) {
        this.jurados = jurados;
    }

    public List<String> getResultados() {
        return resultados;
    }
}
