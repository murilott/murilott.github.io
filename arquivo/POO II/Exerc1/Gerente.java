public class Gerente extends Funcionario {
  

  public Gerente(String cargo, double valorHora, int horasTrab) {
    super(cargo, valorHora, horasTrab);
    setBoni(1.05);
  }
}