package test 

public class testActa {
    @Test
    public void testTotalizar(){
    partidoElectoral[] partidos = new partidoElectoral[2];
  partidos[0] = new partidoElectoral("Partido A", 100);
  partidos[1] = new partidoElectoral("Partido B", 150);
        Acta acta = new Acta(partidos, 250, 10, 5);
        int totalVotos = acta.totalizar();
        assertEquals(250, totalVotos);
    }
}

