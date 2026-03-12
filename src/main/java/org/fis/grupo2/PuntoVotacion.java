package org.fis.grupo2;

public class PuntoVotacion {
    private String ubicacion;
    private int numeroMesas;
    private Mesa[] mesas;
    // para votar virtualmente se asigna un numero de mesa a cada votante
    private String urlMesaVirtual;
    private String codigoMesaVirtual;
    
    
    
    
        public PuntoVotacion(String ubicacion, int numeroMesas) {
        this.ubicacion = ubicacion;
        this.numeroMesas = numeroMesas;
        this.mesas = new Mesa[numeroMesas];

        
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getNumeroMesas() {
        return numeroMesas;
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public String getUrlMesaVirtual() {
        return urlMesaVirtual;
    }
    public void votarVirtual(String urlMesaVirtual, String codigoMesaVirtual) {
        this.urlMesaVirtual = urlMesaVirtual;
        this.codigoMesaVirtual = codigoMesaVirtual;

        // contar el voto virtual en la mesa correspondiente
        mesas[Integer.parseInt(codigoMesaVirtual)].votarVirtual();
    }
}
