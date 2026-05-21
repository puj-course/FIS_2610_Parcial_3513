package org.fis.grupo5.Parcial2.service;
import org.fis.grupo5.Parcial2.entity.Incidente;
import org.fis.grupo5.Parcial2.entity.Mesa;
import org.fis.grupo5.Parcial2.entity.Reclamacion;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;

import java.util.List;

public interface IActa {
    int getId();
    Mesa getMesa();
    List<ResultadoCandidato> getResultados();
    void agregarResultado(ResultadoCandidato resultado);
    void agregarIncidente(Incidente incidente);
    void agregarReclamacion(Reclamacion reclamacion);
}
