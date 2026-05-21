package org.fis.grupo5.Parcial2.observer;

import org.fis.grupo5.Parcial2.entity.Acta;
import java.util.ArrayList;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: OBSERVER — Subject (Observable)
 * =======================================================
 * Extiende la entidad Mesa añadiéndole la capacidad de gestionar
 * suscriptores y notificarlos cuando se publica un Acta.
 *
 * La Mesa es el Subject: cuando los jurados registran el Acta
 * oficial al cierre de la jornada, llama a notificarObservadores()
 * y cada actor suscrito recibe el Acta automáticamente.
 */
public class MesaObservable {

    // ─── Atributos de la entidad Mesa del sistema ──────────────────────────
    private final int id;
    private final int numero;
    private final int censoAproximado;
    private final String nombrePuesto;

    // ─── Gestión de Observadores ──────────────────────────────────────────
    private final List<ObservadorActa> observadores = new ArrayList<>();

    // Última Acta publicada
    private Acta ultimaActa;

    public MesaObservable(int id, int numero, int censoAproximado, String nombrePuesto) {
        this.id               = id;
        this.numero           = numero;
        this.censoAproximado  = censoAproximado;
        this.nombrePuesto     = nombrePuesto;
    }

    // ─── API de suscripción ───────────────────────────────────────────────

    /** Suscribe un observador para recibir notificaciones del Acta. */
    public void suscribir(ObservadorActa observador) {
        observadores.add(observador);
        System.out.println("[Mesa " + numero + "] Suscrito: "
                + observador.getClass().getSimpleName());
    }

    /** Elimina un observador de la lista de suscriptores. */
    public void desuscribir(ObservadorActa observador) {
        observadores.remove(observador);
        System.out.println("[Mesa " + numero + "] Desuscrito: "
                + observador.getClass().getSimpleName());
    }

    // ─── Notificación privada ─────────────────────────────────────────────

    private void notificarObservadores() {
        System.out.println("\n[Mesa " + numero + "] Notificando a "
                + observadores.size() + " observadores...");
        for (ObservadorActa obs : observadores) {
            obs.actualizar(ultimaActa);
        }
    }

    // ─── Lógica de negocio ────────────────────────────────────────────────

    /**
     * Publica el Acta oficial y notifica a todos los suscriptores.
     * Corresponde al cierre de jornada donde los jurados registran
     * los resultados de la mesa.
     *
     * @param acta El Acta con resultados, incidentes y reclamaciones.
     */
    public void publicarActa(Acta acta) {
        System.out.println("\n════════════════════════════════════════");
        System.out.println("[Mesa " + numero + "] Publicando Acta #"
                + acta.getId() + " — " + nombrePuesto);
        this.ultimaActa = acta;
        notificarObservadores();
    }

    // ─── Getters ─────────────────────────────────────────────────────────
    public int getId()               { return id; }
    public int getNumero()           { return numero; }
    public int getCensoAproximado()  { return censoAproximado; }
    public String getNombrePuesto()  { return nombrePuesto; }
    public Acta getUltimaActa()      { return ultimaActa; }
    public List<ObservadorActa> getObservadores() { return observadores; }
}
