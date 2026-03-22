package grupo5;

import java.util.ArrayList;
import java.util.List;

// Clase que permite almacenar y consultar resultados electorales
public class ConsultaResultados {

    // Lista donde se guardan los resultados
    private List<Resultado> resultados;

    // Constructor que inicializa la lista
    public ConsultaResultados() {
        resultados = new ArrayList<>();
    }

    // Método para agregar un resultado a la lista
    public void agregarResultado(Resultado resultado) {
        resultados.add(resultado);
    }

    // Método que muestra todos los resultados registrados
    public void mostrarResultados() {

        // Recorre todos los resultados almacenados
        for (Resultado r : resultados) {

            // Muestra cada resultado
            r.mostrarResultado();

            // Línea para separar resultados
            System.out.println("--------------------");
        }
    }
}
