package org.fis.grupo5.Parcial2.service;
import org.fis.grupo5.Parcial2.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActaProxy implements IActa {
    private ActaReal actaReal;
    private List<String> bitacoraAccesos;
    private String usuarioActual;

    public ActaProxy(ActaReal actaReal, String usuarioActual) {
        this.actaReal = actaReal;
        this.usuarioActual = usuarioActual;
        this.bitacoraAccesos = new ArrayList<>();
    }

    private void registrar(String operacion) {
        String entrada = "[" + LocalDateTime.now() + "] Usuario: " + usuarioActual
                + " | Operación: " + operacion
                + " | Acta ID: " + actaReal.getId();
        bitacoraAccesos.add(entrada);
        System.out.println("AUDITORÍA -> " + entrada);
    }

    public int getId() {
        registrar("consultar ID");
        return actaReal.getId();
    }

    public Mesa getMesa() {
        registrar("consultar Mesa");
        return actaReal.getMesa();
    }

    public List<ResultadoCandidato> getResultados() {
        registrar("consultar Resultados");
        return actaReal.getResultados();
    }

    public void agregarResultado(ResultadoCandidato resultado) {
        registrar("agregar Resultado candidato=" + resultado.getCandidato().getNombre());
        actaReal.agregarResultado(resultado);
    }

    public void agregarIncidente(Incidente incidente) {
        registrar("agregar Incidente tipo=" + incidente.getTipo());
        actaReal.agregarIncidente(incidente);
    }

    public void agregarReclamacion(Reclamacion reclamacion) {
        registrar("agregar Reclamacion solicitante=" + reclamacion.getSolicitante());
        actaReal.agregarReclamacion(reclamacion);
    }

    public List<String> getBitacoraAccesos() {
        return bitacoraAccesos;
    }
}
