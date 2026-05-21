package org.fis.grupo5.Parcial2.strategy;

import org.fis.grupo5.Parcial2.entity.Acta;
import org.fis.grupo5.Parcial2.entity.ResultadoCandidato;
import java.util.List;

/**
 * PATRÓN COMPORTAMENTAL: STRATEGY — Contexto (Context)
 * =====================================================
 * AnalizadorResultados es el Contexto del patrón Strategy.
 * Recibe un Acta y delega el ordenamiento de sus resultados
 * a la EstrategiaOrdenamiento activa, que puede cambiarse
 * en tiempo de ejecución sin modificar esta clase.
 *
 * Rol en el dominio:
 *   Los analistas de la Registraduría necesitan visualizar
 *   los mismos datos del Acta de diferentes maneras según
 *   el informe que se deba generar (oficial, por partido,
 *   comparativo por porcentaje, etc.).
 */
public class AnalizadorResultados {

    private EstrategiaOrdenamiento estrategia;

    public AnalizadorResultados(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Cambia la estrategia en tiempo de ejecución.
     * Permite que el analista seleccione otro criterio de análisis
     * sin detener el proceso.
     */
    public void setEstrategia(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
        System.out.println("\n[Analizador] Estrategia cambiada a: "
                + estrategia.getNombreEstrategia());
    }

    /**
     * Ejecuta la estrategia activa sobre el Acta recibida
     * e imprime el reporte de resultados.
     *
     * @param acta El Acta con los ResultadoCandidato a analizar.
     * @return     Lista ordenada según la estrategia activa.
     */
    public List<ResultadoCandidato> analizar(Acta acta) {
        System.out.println("\n════════════════════════════════════════════════════");
        System.out.println(" ESTRATEGIA : " + estrategia.getNombreEstrategia());
        System.out.println(" ACTA #" + acta.getId()
                + " | Mesa " + acta.getMesa().getNumero());
        System.out.println("────────────────────────────────────────────────────");

        List<ResultadoCandidato> ordenados = estrategia.ordenar(acta);
        int total = ordenados.stream().mapToInt(ResultadoCandidato::getVotos).sum();

        int posicion = 1;
        for (ResultadoCandidato rc : ordenados) {
            String partido = rc.getCandidato().getPartido() != null
                    ? rc.getCandidato().getPartido().getNombre()
                    : "Sin partido";
            double pct = total == 0 ? 0 : (rc.getVotos() * 100.0 / total);
            System.out.printf(" %d. %-25s | %-20s | %4d votos (%5.1f%%)%n",
                    posicion++,
                    rc.getCandidato().getNombre(),
                    partido,
                    rc.getVotos(),
                    pct);
        }
        System.out.println("────────────────────────────────────────────────────");
        System.out.println(" TOTAL VOTOS: " + total);
        System.out.println("════════════════════════════════════════════════════");

        return ordenados;
    }

    public EstrategiaOrdenamiento getEstrategia() {
        return estrategia;
    }
}
