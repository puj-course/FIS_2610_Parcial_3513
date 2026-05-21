package org.fis.grupo3.observer;

class ObservadorAuditoria implements ElectoralObserver {
    @Override
    public void actualizar(String evento, ProcesoElectoral proceso) {
        System.out.println("[AUDITORÍA] Evento '" + evento + "' registrado en el proceso.");
    }
}
