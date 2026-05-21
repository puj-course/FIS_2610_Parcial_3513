package org.fis.grupo5.Parcial2.entity;
public class ResultadoCandidato {
    private int id;
    private Candidato candidato;
    private int votos;
    private Acta acta;

    public ResultadoCandidato(int id, Candidato candidato, int votos, Acta acta) {
        this.id = id;
        this.candidato = candidato;
        this.votos = votos;
        this.acta = acta;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Candidato getCandidato() { return candidato; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }

    public int getVotos() { return votos; }
    public void setVotos(int votos) { this.votos = votos; }

    public Acta getActa() { return acta; }
    public void setActa(Acta acta) { this.acta = acta; }
}