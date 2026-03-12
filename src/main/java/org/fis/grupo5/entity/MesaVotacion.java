import java.util.ArrayList;

public class MesaVotacion {

    private int idMesa;
    private int numeroMesa;
    private int censoVotantes;
    private ArrayList<Jurado> jurados;

    public MesaVotacion(int idMesa, int numeroMesa, int censoVotantes) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.censoVotantes = censoVotantes;
        this.jurados = new ArrayList<>();
    }

    public void asignarJurado(Jurado jurado) {
        jurados.add(jurado);
    }

    public void mostrarJurados() {
        System.out.println("Jurados de la mesa " + numeroMesa + ":");

        for (Jurado j : jurados) {
            System.out.println("- " + j.getNombre());
        }
    }
}