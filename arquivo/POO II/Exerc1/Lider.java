public class Lider extends Funcionario {
  

  public Lider(String cargo, double valorHora, int horasTrab) {
    super(cargo, valorHora, horasTrab);
    setBoni(1.02);
  }
}