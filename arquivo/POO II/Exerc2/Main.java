public class Main {
  public static void main(String[] args) {
    // double[] a = new double [5];
    // double[] b = new double []{0.2, 0.3};
    // a[0] = 5.2;
    // a[1] = 5;
    // a[2] = 3.1;
    // System.out.println(a[0]);
    // System.out.println(b[0]);

    // for (int i=0; i<(a.length); i++ ) {
    //   System.out.println(a[i]);
    // }

    // Começo 2 *********** 
    
    // Progressao prog = new Progressao(2, 4, 5);
    // prog.setRazao(2);
    // prog.setPriTermo(3);
    // prog.setnTermo(4);

    // System.out.println(prog.getRazao());

    // ProgAritmetica progAri = new ProgAritmetica(2, 2, 5);
    // progAri.gerarProgressao();
    // progAri.proxNumero(2, 10);
    // progAri.acharTermo(2, 2, 10);

    // ProgGeometrica progGeo = new ProgGeometrica(2, 2, 5);
    // progGeo.gerarProgressao();
    // progGeo.proxNumero(2, 10);
    // progGeo.acharTermo(2, 2, 5);

    // ProgFibonacci progFibo = new ProgFibonacci(10);
    // progFibo.gerarProgressao();
    // Fim 2

    // Começo 3 ********* 
    Retangulo ret = new Retangulo(10, 4, "oi");
    ret.desenharRetangulo();

    RetanguloRosa retRosa = new RetanguloRosa(10, 4, "oi");
    retRosa.desenharRetangulo();

    System.out.println("");
    
    RetanguloDestacado retDest = new RetanguloDestacado(10, 4, "oi");
    retDest.desenharRetangulo();

    System.out.println("");

    RetanguloSombreado retSomb = new RetanguloSombreado(10, 4, "oi");
    retSomb.desenharRetangulo();

    // Shape sh = new Shape("shape");
    // Retangulo2 ret2 = new Retangulo2("Ret2", 10, 2);
    // Circulo cir = new Circulo("cir", 10);
    // Losango los = new Losango("los", 10, 5);
    // Hexagono hex = new Hexagono("hex", 10, 5);
    // Pentagono pen = new Pentagono("pen", 10, 5);
    

    // sh.calcArea();
    // ret2.calcArea();
    // cir.calcArea();
    // los.calcArea();
    // hex.calcArea();
    // pen.calcArea();

    // sh.calcPerimetro();
    // ret2.calcPerimetro();
    // cir.calcPerimetro();
    // los.calcPerimetro();
    // hex.calcPerimetro();
    // pen.calcPerimetro();
  }
}