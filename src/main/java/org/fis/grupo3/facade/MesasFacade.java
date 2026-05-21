package org.fis.grupo3.facade;

import org.fis.grupo3.Jurado;
import org.fis.grupo3.Mesas;
import org.fis.grupo3.PustosVotacion;|

import java.util.ArrayList;
import java.util.List;

public class MesasVotacionFacade {

    private final List<Mesas> mesas = new ArrayList<>();
    private final List<Jurado> jurados = new ArrayList<>();
    private final List<PustosVotacion> puestos = new ArrayList<>();

    public void registrarMesa(Mesas mesa) {
        if (mesa == null) {
            throw new IllegalArgumentException("La mesa no puede ser nula.");
        }
        mesas.add(mesa);
    }

    public void registrarJurado(Jurado jurado) {
        if (jurado == null) {
            throw new IllegalArgumentException("El jurado no puede ser nulo.");
        }
        jurados.add(jurado);
    }

    public void registrarPuesto(PustosVotacion puesto) {
        if (puesto == null) {
            throw new IllegalArgumentException("El puesto no puede ser nulo.");
        }
        puestos.add(puesto);
    }

    public void instalarMesa(int mesaId) {
        Jurado jurado = buscarJurado(mesaId);
        jurado.instalarMesas();
    }

    public void atenderVotanteEnMesa(int mesaId) {
        Jurado jurado = buscarJurado(mesaId);
        jurado.atenderVotante();
    }

    public int cerrarMesa(int mesaId) {
        Jurado jurado = buscarJurado(mesaId);
        return jurado.registrarResultado();
    }

    public List<String> consolidarResultados() {
        List<String> resultados = new ArrayList<>();

        for (PustosVotacion puesto : puestos) {
            if (puesto.getResultados() != null) {
                resultados.addAll(puesto.getResultados());
            }
        }

        return resultados;
    }

    public int totalMesas() {
        return mesas.size();
    }

    public int totalJurados() {
        return jurados.size();
    }

    public int totalPuestos() {
        return puestos.size();
    }

    private Jurado buscarJurado(int mesaId) {
        for (Jurado jurado : jurados) {
            if (jurado.getMesaId() == mesaId) {
                return jurado;
            }
        }

        throw new IllegalStateException("No hay jurado asignado a la mesa " + mesaId + ".");
    }
}
