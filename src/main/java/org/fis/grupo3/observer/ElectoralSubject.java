package org.fis.grupo3.observer;

interface ElectoralSubject {
    void agregarObservador(ElectoralObserver o);

    void eliminarObservador(ElectoralObserver o);

    void notificarObservadores(String evento);
}
