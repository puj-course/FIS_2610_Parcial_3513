import java.util.ArrayList;

public class SistemaElectoral {

    private ArrayList<Candidato> candidatos;
    private ArrayList<PartidoPolitico> partidos;

    public SistemaElectoral() {
        candidatos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void registrarPartido(PartidoPolitico partido) {
        partidos.add(partido);
    }

    public void registrarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public void mostrarCandidatos() {

        System.out.println("Lista de candidatos:");

        for (Candidato c : candidatos) {
            c.mostrarCandidato();
            System.out.println();
        }
    }
}