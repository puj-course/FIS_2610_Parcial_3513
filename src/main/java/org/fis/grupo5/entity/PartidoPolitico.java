public class PartidoPolitico {

    private int idPartido;
    private String nombre;
    private String sigla;

    public PartidoPolitico(int idPartido, String nombre, String sigla) {
        this.idPartido = idPartido;
        this.nombre = nombre;
        this.sigla = sigla;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void mostrarPartido() {
        System.out.println(nombre + " (" + sigla + ")");
    }
}