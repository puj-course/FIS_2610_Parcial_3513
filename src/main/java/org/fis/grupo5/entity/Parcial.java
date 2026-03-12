import java.util.ArrayList;
import java.util.List;

class Mesa {
    private int numero;
    private int capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Mesa #" + numero + " (Capacidad: " + capacidad + ")";
    }
}

class Puesto {
    private String nombre;
    private String direccion;
    private String municipio;
    private int capacidad;
    private List<Mesa> mesas;

    public Puesto(String nombre, String direccion, String municipio, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.capacidad = capacidad;
        this.mesas = new ArrayList<>();
    }

    public void crearMesa(int capacidadMesa) {
        int numeroMesa = mesas.size() + 1;
        mesas.add(new Mesa(numeroMesa, capacidadMesa));
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    @Override
    public String toString() {
        return "Puesto: " + nombre + " - " + direccion + " (" + municipio + ")"
                + " Capacidad: " + capacidad + " | Mesas: " + mesas.size();
    }
}

public class SistemaElectoral {
    private List<Puesto> puestos;

    public SistemaElectoral() {
        this.puestos = new ArrayList<>();
    }

    public void registrarPuesto(String nombre, String direccion, String municipio, int capacidad) {
        for (Puesto p : puestos) {
            if (p.toString().contains(nombre)) {
                System.out.println("El puesto ya existe: " + nombre);
                return;
            }
        }
        puestos.add(new Puesto(nombre, direccion, municipio, capacidad));
        System.out.println("Puesto registrado: " + nombre);
    }

    public void mostrarPuestos() {
        for (Puesto p : puestos) {
            System.out.println(p);
            for (Mesa m : p.getMesas()) {
                System.out.println("   - " + m);
            }
        }
    }

    public static void main(String[] args) {
        SistemaElectoral sistema = new SistemaElectoral();

        sistema.registrarPuesto("Colegio Nacional", "Calle 123", "Bogotá", 500);
        sistema.registrarPuesto("Universidad Central", "Carrera 45", "Bogotá", 800);

        sistema.puestos.get(0).crearMesa(200);
        sistema.puestos.get(0).crearMesa(150);
        sistema.puestos.get(1).crearMesa(300);

        sistema.mostrarPuestos();
    }
}
