public class Acta {
    private partidoElectoral[] partidos;
    private int totalVotos;
    private int votosNulos;
    private int votosBlancos;
  
    public Acta(partidoElectoral[] partidos, int totalVotos, int votosNulos, int votosBlancos){
      this.partidos = partidos;
      this.totalVotos = totalVotos;
      this.votosNulos = votosNulos;
      this.votosBlancos = votosBlancos;
    }

    int totalizar(){
      for (int i = 0; i < totalVotos; i++){
        for (int j = 0; j < partidos.candidatos.size(); j++){
         partidos.NumeroVotos++;
        // sumar votos totales del partido por candidato
      }
    }
  }
}
