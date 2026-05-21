package org.fis.grupo3.observer;

import org.fis.grupo3.model.Candidatos;
import org.fis.grupo3.model.Jurado;
import org.fis.grupo3.model.Mesas;
import org.fis.grupo3.model.PartidoPoliticos;
import org.fis.grupo3.model.PustosVotacion;

import java.util.*;

public class ProcesoElectoral implements ElectoralSubject {
    private int id;
    private String tipoEleccion;
    private List<PustosVotacion> pustosVotacion;
    private Mesas mesas;
    private Jurado jurado;
    private PartidoPoliticos partidoPoliticos;
    private Candidatos candidatos;
    private final List<ElectoralObserver> observadores = new ArrayList<>();
    @Override
    public void agregarObservador(ElectoralObserver o)  { observadores.add(o); }
    @Override
    public void eliminarObservador(ElectoralObserver o) { observadores.remove(o); }
    @Override
    public void notificarObservadores(String evento) {
        for (ElectoralObserver o : observadores) o.actualizar(evento, this);
    }
    //Cambios de estado que se deben notificar
    public void iniciarProceso() {
        System.out.println("Proceso electoral iniciado.");
        notificarObservadores("INICIO");
    }
    public void mostrarResultados() {
        List<String> resultado;
        for (PustosVotacion pv : pustosVotacion) {
            resultados = pv.getResultados();
        }
        notificarObservadores("RESULTADOS");
    }
    public void cerrarProceso() {
        System.out.println("Proceso electoral cerrado.");
        notificarObservadores("CIERRE");
    }
}

