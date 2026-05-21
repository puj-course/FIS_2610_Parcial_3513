package org.fis.grupo5.electoral.observer;

import org.fis.grupo5.electoral.modelo.Acta;

/**
 * Observador concreto que representa a la autoridad electoral (RegistradurÃ­a / CNE).
 * Audita las actas y dispara alarmas crÃ­ticas si los votos superan el censo electoral.
 */
public class AutoridadElectoral implements ObservadorProceso {
    private final String nombreAutoridad;
    private final int censoElectoralMesa;

    public AutoridadElectoral(String nombreAutoridad, int censoElectoralMesa) {
        if (nombreAutoridad == null || nombreAutoridad.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la autoridad electoral no puede ser nulo o vacÃ­o.");
        }
        if (censoElectoralMesa <= 0) {
            throw new IllegalArgumentException("El censo electoral de la mesa debe ser mayor que cero.");
        }
        this.nombreAutoridad = nombreAutoridad.trim();
        this.censoElectoralMesa = censoElectoralMesa;
    }

    @Override
    public void actualizar(String mesaId, Acta acta) {
        if (acta == null) {
            return;
        }

        int totalVotos = acta.getTotalVotos();
        System.out.println("\n--- [AUDITORÃA OFICIAL] " + nombreAutoridad.toUpperCase() + " en MESA: " + mesaId + " ---");
        System.out.println(" > Votos Totales Registrados: " + totalVotos + " / Censo Electoral Autorizado: " + censoElectoralMesa);

        if (totalVotos > censoElectoralMesa) {
            System.err.println("ðŸš¨ [ALERTA DE SEGURIDAD - POSIBLE FRAUDE] La mesa " + mesaId 
                    + " reporta " + totalVotos + " votos, lo cual SUPERA el censo autorizado de " 
                    + censoElectoralMesa + "!");
        } else {
            System.out.println(" âœ… Acta auditada con Ã©xito. VotaciÃ³n dentro de los lÃ­mites del censo electoral.");
        }
    }

    @Override
    public String getNombre() {
        return "Autoridad Electoral: " + nombreAutoridad;
    }

    public String getNombreAutoridad() {
        return nombreAutoridad;
    }

    public int getCensoElectoralMesa() {
        return censoElectoralMesa;
    }
}
