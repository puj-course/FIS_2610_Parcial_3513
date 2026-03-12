public class Candidato {

    private int idCandidato;
    private String nombre;
    private String cargo;
    private PartidoPolitico partido;

    public Candidato(int idCandidato, String nombre, String cargo, PartidoPolitico partido) {
        this.idCandidato = idCandidato;
        this.nombre = nombre;
        this.cargo = cargo;
        this.partido = partido;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public String getNombre() {
        return nombre;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void mostrarCandidato() {
        System.out.println("Candidato: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Partido: " + partido.getNombre());
    }
}