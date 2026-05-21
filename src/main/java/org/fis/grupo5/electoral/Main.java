package org.fis.grupo5.electoral;

import org.fis.grupo5.electoral.modelo.Acta;
import org.fis.grupo5.electoral.modelo.Candidato;
import org.fis.grupo5.electoral.observer.AnalistaResultados;
import org.fis.grupo5.electoral.observer.AutoridadElectoral;
import org.fis.grupo5.electoral.observer.PartidoPolitico;

import java.time.LocalDate;

/**
 * Clase principal que actÃºa como demo para evidenciar el correcto funcionamiento
 * del patrÃ³n Observer aplicado a la GestiÃ³n y Transparencia Electoral.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================================================");
        System.out.println("   DEMO: PATRÃ“N OBSERVER EN SISTEMA ELECTORAL - COLOMBIA 2026");
        System.out.println("=====================================================================");

        // 1. Crear Candidatos
        Candidato cand1 = new Candidato("101", "Valeria GÃ³mez", "Partido del Futuro");
        Candidato cand2 = new Candidato("102", "Juan PÃ©rez", "UniÃ³n DemocrÃ¡tica");
        Candidato cand3 = new Candidato("103", "Federico Silva", "Movimiento CÃ­vico");

        // 2. Escenario 1: Flujo de VotaciÃ³n Normal y Escrutinio Transparente
        System.out.println("\n>>> [ESCENARIO 1] ESCENARIO DE VOTACIÃ“N NORMAL (BAJO EL CENSO AUTORIZADO)");
        
        // Crear la Mesa de VotaciÃ³n (Subject)
        MesaVotacion mesa25 = new MesaVotacion("MESA-25");
        System.out.println("Creada Mesa: " + mesa25.getId());

        // Instanciar Observadores
        PartidoPolitico veedorPartido = new PartidoPolitico("Partido del Futuro");
        AutoridadElectoral registraduria = new AutoridadElectoral("RegistradurÃ­a Nacional CNE", 350); // Censo: 350
        AnalistaResultados analista = new AnalistaResultados("DecisiÃ³n Electoral 2026");

        // Registrar Observadores en la Mesa
        System.out.println("\nRegistrando observadores de transparencia...");
        mesa25.registrarObservador(veedorPartido);
        mesa25.registrarObservador(registraduria);
        mesa25.registrarObservador(analista);

        // Crear el Acta de la mesa
        Acta actaMesa25 = new Acta("A25", "MESA-25", LocalDate.of(2026, 3, 8));
        actaMesa25.agregarResultado(cand1, 140); // Partido del Futuro
        actaMesa25.agregarResultado(cand2, 90);  // UniÃ³n DemocrÃ¡tica
        actaMesa25.agregarResultado(cand3, 70);  // Movimiento CÃ­vico

        // Registrar el acta en la mesa (Gatilla las notificaciones automÃ¡ticas)
        System.out.println("\n>>> El Jurado registra el Acta de Escrutinio en MESA-25...");
        mesa25.registrarActa(actaMesa25);

        // 3. Escenario 2: Alerta de Consistencia / Posible Fraude (Exceso de Censo)
        System.out.println("\n\n>>> [ESCENARIO 2] ESCENARIO DE ALERTA CRÃTICA (SUPERACIÃ“N DEL CENSO ELECTORAL)");
        
        MesaVotacion mesa88 = new MesaVotacion("MESA-88");
        System.out.println("Creada Mesa: " + mesa88.getId());

        // Registramos observadores de control electoral para esta nueva mesa
        AutoridadElectoral cne = new AutoridadElectoral("Consejo Nacional Electoral", 200); // Censo estricto: 200
        PartidoPolitico veedorPartidoFuturo = new PartidoPolitico("Partido del Futuro");
        
        mesa88.registrarObservador(cne);
        mesa88.registrarObservador(veedorPartidoFuturo);

        // Crear acta con votos inflados (supera el censo de 200)
        Acta actaMesa88 = new Acta("A88", "MESA-88", LocalDate.of(2026, 3, 8));
        actaMesa88.agregarResultado(cand1, 210); // Supera el censo por sÃ­ solo!
        actaMesa88.agregarResultado(cand2, 50);
        actaMesa88.agregarResultado(cand3, 60);  // Total: 320 votos

        System.out.println("\n>>> El Jurado registra el Acta de Escrutinio en MESA-88...");
        mesa88.registrarActa(actaMesa88);

        System.out.println("\n=====================================================================");
        System.out.println("   DEMO COMPLETADA: EL PATRÃ“N OBSERVER REACCIONÃ“ CON TOTAL Ã‰XITO");
        System.out.println("=====================================================================");
    }
}
