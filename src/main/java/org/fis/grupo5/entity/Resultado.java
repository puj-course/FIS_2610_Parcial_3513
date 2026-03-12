package grupo5;

// Clase que representa los resultados de votación de un candidato
public class Resultado {

    // Nombre del candidato
    private String candidato;

    // Cantidad de votos obtenidos
    private int votos;

    // Número de la mesa donde se registraron los votos
    private int mesa;

    // Constructor de la clase
    public Resultado(String candidato, int votos, int mesa) {
        this.candidato = candidato;
        this.votos = votos;
        this.mesa = mesa;
    }

    // Método que retorna el nombre del candidato
    public String getCandidato() {
        return candidato;
    }

    // Método que retorna la cantidad de votos
    public int getVotos() {
        return votos;
    }

    // Método que retorna la mesa
    public int getMesa() {
        return mesa;
    }

    // Método para mostrar el resultado en consola
    public void mostrarResultado() {
        System.out.println("Candidato: " + candidato);
        System.out.println("Votos: " + votos);
        System.out.println("Mesa: " + mesa);
    }
}