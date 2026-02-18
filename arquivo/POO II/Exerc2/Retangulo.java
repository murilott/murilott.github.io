public class Retangulo {
  public int altura;
  public int largura;
  public String texto;

  public Retangulo(int altura, int largura, String texto) {
    this.altura = altura;
    this.largura = largura;
    this.texto = texto;
  }

  public void desenharRetangulo() {
    for (int i=0; i<=largura; i++) {
      System.out.print("#");

      for (int j=0; j<=altura; j++) {
        if (i == 0) {
          System.out.print("#");
        }
        if  (i == largura){
          System.out.print("#");
        }
        
        if (i == (largura/2) && j == (altura/2)) {
          System.out.print("   " + texto);
        }
      }

      System.out.println("");
    }

    System.out.println("");
    System.out.println("");
  }
}