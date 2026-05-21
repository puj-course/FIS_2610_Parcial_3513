package org.fis.grupo3.observer;

class ObservadorNotificacion implements ElectoralObserver {
    @Override
    public void actualizar(String evento, ProcesoElectoral proceso) {
        System.out.println("[NOTIFICACIÓN] Se envió alerta por evento: " + evento);
    }
}
