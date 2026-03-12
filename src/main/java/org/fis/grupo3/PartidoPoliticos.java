package org.fis.grupo3;
import java.util.List;

public class PartidoPoliticos {
    private String idPartido;
    private String nombre;
    private String sigla;
    private String representanteLegal;

    private List<Candidatos> candidatosInscritos;

    public PartidoPoliticos(String idPartido, String nombre, String sigla, String representanteLegal, List<Candidato> candidatosInscritos) {
        this.idPartido = idPartido;
        this.nombre = nombre;
        this.sigla = sigla;
        this.representanteLegal = representanteLegal;
        this.candidatosInscritos = candidatosInscritos;
    }

    // Asociar candidato al partido
    public void agregarCandidato(Candidatos candidato) {
        candidatosInscritos.add(candidato);
    }

    // Consultar candidatos del partido

    public List<Candidatos> obtenerCandidatos() {
        return candidatosInscritos;
    }
}
