package org.fis.grupo3.model;
interface JuradoComponent {
    void instalarMesas();
    void atenderVotante();
    int registrarResultado();
    String getCedula();
    String getFuncion();
    int getMesaId();
}
class Jurado implements JuradoComponent{
    private int idJurado;
    private String cedula;
    private String funcion;
    private int mesaId;
    public int getIdJurado() {return idJurado;}
    @Override public String getCedula() {return cedula; }
    @Override public String getFuncion() {return funcion; }
    @Override public int getMesaId() {return mesaId; }
    @Override
    public void instalarMesas() {
        System.out.println("Mesa " + mesaId + " instalada por el jurado " + cedula + ".");
    }
    @Override
    public void atenderVotante() {
        System.out.println("El jurado " + cedula + " está atendiendo a un votante.");
    }
    @Override
    public int registrarResultado() {
        System.out.println("Resultados registrados por el jurado " + cedula + ".");
        return 0;
    }
}
abstract class JuradoDecorator implements JuradoComponent {
    protected final JuradoComponent jurado;
    protected JuradoDecorator(JuradoComponent jurado) {
        this.jurado = jurado;
    }
    @Override public void instalarMesas() {jurado.instalarMesas(); }
    @Override public void atenderVotante() {jurado.atenderVotante(); }
    @Override public int registrarResultado() {return jurado.registrarResultado(); }
    @Override public String getCedula() {return jurado.getCedula(); }
    @Override public String getFuncion() {return jurado.getFuncion(); }
    @Override public int getMesaId() { return jurado.getMesaId(); }
}
//Extension de funcion de jurado, jurado que anota en bitacora
class JuradoConBitacora extends JuradoDecorator {
    public JuradoConBitacora(JuradoComponent jurado) {
        super(jurado);
    }
    @Override
    public void instalarMesas() {
        System.out.println("[BITÁCORA] Inicio instalarMesas – " + now());
        super.instalarMesas();
        System.out.println("[BITÁCORA] Fin instalarMesas – " + now());
    }
    @Override
    public void atenderVotante() {
        System.out.println("[BITÁCORA] Inicio atenderVotante – " + now());
        super.atenderVotante();
        System.out.println("[BITÁCORA] Fin atenderVotante – " + now());
    }
    @Override
    public int registrarResultado() {
        System.out.println("[BITÁCORA] Inicio registrarResultado – " + now());
        int resultado = super.registrarResultado();
        System.out.println("[BITÁCORA] Fin registrarResultado (resultado=" + resultado + ") – " + now());
        return resultado;
    }
    private String now() {
        return new java.util.Date().toString();
    }
}
//Extension de funcion de jurado, jurado que valida el registro
class JuradoConValidacion extends JuradoDecorator{
    public JuradoConValidacion(JuradoComponent jurado){
        super(jurado);
    }
    private void validar(){
        if (jurado.getCedula() == null || jurado.getCedula().isBlank()) {
            throw new IllegalStateException("El jurado no tiene cédula válida registrada.");
        }
    }
    @Override
    public void instalarMesas() {
        validar();
        super.instalarMesas();
    }
    @Override
    public void atenderVotante() {
        validar();
        super.atenderVotante();
    }
    @Override
    public int registrarResultado() {
        validar();
        return super.registrarResultado();
    }
}
