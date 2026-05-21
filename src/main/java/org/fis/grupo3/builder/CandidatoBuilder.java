package org.fis.grupo3.builder;

import org.fis.grupo3.Candidato;

public class CandidatoBuilder {

    private String cedula;
    private String numeroTarjeton;  

    public CandidatoBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public CandidatoBuilder numeroTarjeton(String numeroTarjeton) {
        this.numeroTarjeton = numeroTarjeton;
        return this;
    }

    public Candidato build() {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalStateException("La cédula es obligatoria.");
        }

        if (!cedula.matches("\\d+")) {
            throw new IllegalStateException("La cédula solo debe contener números.");
        }

        if (numeroTarjeton == null || numeroTarjeton.isBlank()) {
            throw new IllegalStateException("El número de tarjetón es obligatorio.");
        }

        return new Candidato(cedula, numeroTarjeton);
    }
}
