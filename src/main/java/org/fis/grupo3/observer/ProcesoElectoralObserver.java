package org.fis.grupo3.model;

import java.util.*;
//Interfaz observer
interface ElectoralObserver {
    void actualizar(String evento, ProcesoElectoral proceso);
}
interface ElectoralSubject {
    void agregarObservador(ElectoralObserver o);
    void eliminarObservador(ElectoralObserver o);
    void notificarObservadores(String evento);
}
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
class ObservadorAuditoria implements ElectoralObserver{
    @Override
    public void actualizar(String evento, ProcesoElectoral proceso){
        System.out.println("[AUDITORÍA] Evento '" + evento + "' registrado en el proceso.");
    }
}
class ObservadorNotificacion implements ElectoralObserver{
    @Override
    public void actualizar(String evento, ProcesoElectoral proceso){
        System.out.println("[NOTIFICACIÓN] Se envió alerta por evento: " + evento);
    }
}
