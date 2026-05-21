package org.fis.grupo5.electoral.modelo;

import java.util.Objects;

/**
 * Representa un candidato en las elecciones legislativas.
 */
public class Candidato {
    private final String id;
    private final String nombre;
    private final String partido;

    public Candidato(String id, String nombre, String partido) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del candidato no puede ser nulo o vacÃ­o.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del candidato no puede ser nulo o vacÃ­o.");
        }
        if (partido == null || partido.trim().isEmpty()) {
            throw new IllegalArgumentException("El partido del candidato no puede ser nulo o vacÃ­o.");
        }
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.partido = partido.trim();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartido() {
        return partido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return Objects.equals(id, candidato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", partido='" + partido + '\'' +
                '}';
    }
}
