public class Jurado {

    private int idJurado;
    private String nombre;
    private String rol;
    private MesaVotacion mesaAsignada;

    public Jurado(int idJurado, String nombre, String rol) {
        this.idJurado = idJurado;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void asignarMesa(MesaVotacion mesa) {
        this.mesaAsignada = mesa;
        mesa.asignarJurado(this);
    }
}