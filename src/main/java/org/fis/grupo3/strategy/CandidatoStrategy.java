package org.fis.grupo3.model;
interface CandidatoStrategy {
    boolean ejecutar(Candidato candidato);
}
class ValidarCedulaStrategy implements CandidatoStrategy {
    @Override
    public boolean ejecutar(Candidato c) {
        boolean valida = c.getCedula() != null && c.getCedula().matches("\\d{6,10}");
        System.out.println("[CÉDULA] " + (valida ? "Válida" : "Inválida") + ": " + c.getCedula());
        return valida;
    }
}
class ValidarTarjetonStrategy implements CandidatoStrategy {
    @Override
    public boolean ejecutar(Candidato c) {
        boolean valido = c.getNumeroTarjeton() != null && !c.getNumeroTarjeton().isBlank();
        System.out.println("[TARJETÓN] " + (valido ? "Válido" : "Inválido") + ": " + c.getNumeroTarjeton());
        return valido;
    }
}
class ValidacionCompletaStrategy implements CandidatoStrategy {
    private final CandidatoStrategy cedula   = new ValidarCedulaStrategy();
    private final CandidatoStrategy tarjeton = new ValidarTarjetonStrategy();

    @Override
    public boolean ejecutar(Candidato c) {
        return cedula.ejecutar(c) && tarjeton.ejecutar(c);
    }
}
