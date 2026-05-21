package org.fis.grupo3.prototype;

import org.fis.grupo3.Jurado;
import org.fis.grupo3.PustosVotacion;

public class PuestoVotacionPrototype {

    private final Jurado juradoBase;

    public PuestoVotacionPrototype(Jurado juradoBase) {
        if (juradoBase == null) {
            throw new IllegalArgumentException("El jurado base no puede ser nulo.");
        }

        this.juradoBase = juradoBase;
    }

    public PustosVotacion clonar() {
        Jurado copiaJurado = new Jurado(
            juradoBase.getIdJurado(),
            juradoBase.getCedula(),
            juradoBase.getFuncion(),
            juradoBase.getMesaId()
        );

        return new PustosVotacion(copiaJurado);
    }
}
