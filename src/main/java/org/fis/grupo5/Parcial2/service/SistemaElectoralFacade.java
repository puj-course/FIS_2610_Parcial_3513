import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SistemaElectoralFacade {

    private ProcesoElectoral procesoActual;

    public SistemaElectoralFacade() {}

    public ProcesoElectoral registrarProceso(int id, String tipo, LocalDate fecha, String estado) {
        procesoActual = new ProcesoElectoral(id, tipo, fecha, estado);
        System.out.println("Proceso electoral registrado: " + tipo + " | Fecha: " + fecha);
        return procesoActual;
    }

    public Departamento registrarDepartamento(int id, String nombre, String codigo) {
        Departamento dep = new Departamento(id, nombre, codigo);
        if (procesoActual != null) {
            procesoActual.getDepartamentos().add(dep);
        }
        System.out.println("Departamento registrado: " + nombre);
        return dep;
    }

    public Municipio registrarMunicipio(int id, String nombre, Departamento departamento) {
        Municipio mun = new Municipio(id, nombre, departamento);
        departamento.getMunicipios().add(mun);
        System.out.println("Municipio registrado: " + nombre + " en " + departamento.getNombre());
        return mun;
    }

    public PuestoDeVotacion registrarPuesto(int id, String nombre, String ubicacion, Municipio municipio) {
        PuestoDeVotacion puesto = new PuestoDeVotacion(id, nombre, ubicacion, municipio);
        municipio.getPuestos().add(puesto);
        System.out.println("Puesto registrado: " + nombre + " en " + municipio.getNombre());
        return puesto;
    }

    public Mesa registrarMesa(int id, int numero, int censo, PuestoDeVotacion puesto) {
        Mesa mesa = new Mesa(id, numero, censo, puesto);
        puesto.getMesas().add(mesa);
        System.out.println("Mesa " + numero + " registrada en puesto: " + puesto.getNombre());
        return mesa;
    }

    public Candidato registrarCandidato(int id, String nombre, String cedula, PartidoPolitico partido) {
        Candidato candidato = new Candidato(id, nombre, cedula, partido);
        partido.getCandidatos().add(candidato);
        if (procesoActual != null) {
            procesoActual.getCandidatos().add(candidato);
        }
        System.out.println("Candidato registrado: " + nombre + " | Partido: " + partido.getNombre());
        return candidato;
    }

    public Jurado asignarJurado(int id, String nombre, String cedula, String funcion, Mesa mesa) {
        Jurado jurado = new Jurado(id, nombre, cedula, funcion, mesa);
        mesa.getJurados().add(jurado);
        System.out.println("Jurado " + nombre + " asignado a mesa " + mesa.getNumero() + " | Función: " + funcion);
        return jurado;
    }

    public IActa abrirActaConAuditoria(int id, Mesa mesa, String usuarioResponsable) {
        ActaReal actaReal = new ActaReal(id, mesa, LocalDateTime.now());
        ActaProxy proxy = new ActaProxy(actaReal, usuarioResponsable);
        System.out.println("Acta " + id + " abierta con auditoría para usuario: " + usuarioResponsable);
        return proxy;
    }

    public void consultarResultadosTerritorio(Departamento departamento) {
        System.out.println("=== Resultados para: " + departamento.getNombre() + " ===");
        for (Municipio mun : departamento.getMunicipios()) {
            System.out.println("  Municipio: " + mun.getNombre());
            for (PuestoDeVotacion puesto : mun.getPuestos()) {
                System.out.println("    Puesto: " + puesto.getNombre() + " | Mesas: " + puesto.getMesas().size());
            }
        }
    }

    public ProcesoElectoral getProcesoActual() { return procesoActual; }
}