package org.fis.grupo5.electoral.modelo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa el acta de escrutinio de una mesa de votaciÃ³n,
 * registrando los votos obtenidos por cada candidato.
 */
public class Acta {
    private final String id;
    private final String mesaId;
    private final LocalDate fecha;
    private final Map<Candidato, Integer> resultados;

    public Acta(String id, String mesaId, LocalDate fecha) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del acta no puede ser nulo o vacÃ­o.");
        }
        if (mesaId == null || mesaId.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la mesa no puede ser nulo o vacÃ­o.");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha del acta no puede ser nula.");
        }
        this.id = id.trim();
        this.mesaId = mesaId.trim();
        this.fecha = fecha;
        this.resultados = new HashMap<>();
    }

    public void agregarResultado(Candidato candidato, int votos) {
        if (candidato == null) {
            throw new IllegalArgumentException("El candidato no puede ser nulo.");
        }
        if (votos < 0) {
            throw new IllegalArgumentException("La cantidad de votos no puede ser negativa.");
        }
        this.resultados.put(candidato, this.resultados.getOrDefault(candidato, 0) + votos);
    }

    public String getId() {
        return id;
    }

    public String getMesaId() {
        return mesaId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Retorna una copia de los resultados para mantener la encapsulaciÃ³n.
     */
    public Map<Candidato, Integer> getResultados() {
        return Collections.unmodifiableMap(resultados);
    }

    public int getTotalVotos() {
        return resultados.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return "Acta{" +
                "id='" + id + '\'' +
                ", mesaId='" + mesaId + '\'' +
                ", fecha=" + fecha +
                ", totalVotos=" + getTotalVotos() +
                '}';
    }
}
