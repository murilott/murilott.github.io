public class RetanguloRosa extends Retangulo {
  public String fundo;
  public String bordaFormato;
  public String MAGENTA = "\u001B[35m";
  public String RESET = "\u001B[0m";

  public RetanguloRosa(int altura, int largura, String texto) {
    super(altura, largura, texto);
    // this.fundo = fundo;
    // this.bordaFormato = bordaFormato;
  }

  public void desenharRetangulo() {
    for (int i=0; i<=largura; i++) {
      System.out.print("#");

      for (int j=0; j<=altura; j++) {
        if (i == 0 | i == largura) {
          System.out.print("#");
        } else {
          System.out.print(MAGENTA + "O" + RESET);
        }

        if (i == (largura/2) && j == (altura/2)) {
          System.out.print(texto);
        }
      }

      System.out.println("");
    }
  }
}