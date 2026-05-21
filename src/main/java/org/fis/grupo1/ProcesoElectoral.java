package org.fis.grupo1;

public class ProcesoElectoral {
    private String tipo;
    private String fecha;
    private String estado;

    public ProcesoElectoral(String tipo, String fecha, String estado) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() { // Método para mostrar la información del proceso electoral
        return " Registrando Proceso Electoral " +
               "Tipo: " + tipo + "Fecha: " + fecha + "Estado: " + estado  + "Candidatos asociados:" +"Votantes habilitados" +"Mesas electorales: ";
    }

    public static void main(String[] args) { //main para probar la clase ProcesoElectoral 
        ProcesoElectoral proceso = new ProcesoElectoral("Presidencial", "2026-05-15", "Activo");
        System.out.println(proceso);
    }
}
