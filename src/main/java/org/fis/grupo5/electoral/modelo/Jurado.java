package org.fis.grupo5.electoral.modelo;

import java.util.Objects;

/**
 * Representa un jurado asignado a una mesa de votaciÃ³n.
 */
public class Jurado {
    private final String id;
    private final String nombre;
    private final String funcion;

    public Jurado(String id, String nombre, String funcion) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del jurado no puede ser nulo o vacÃ­o.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jurado no puede ser nulo o vacÃ­o.");
        }
        if (funcion == null || funcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La funciÃ³n del jurado no puede ser nula o vacÃ­a.");
        }
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.funcion = funcion.trim();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFuncion() {
        return funcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jurado jurado = (Jurado) o;
        return Objects.equals(id, jurado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Jurado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", funcion='" + funcion + '\'' +
                '}';
    }
}
