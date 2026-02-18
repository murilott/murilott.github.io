
public class Main {
  public static void main(String[] args) {
    // 2
    // Crie um programa para calcular o sal´ario dos funcion´arios de uma
    // empresa. O sal´ario ´e baseado no valor hora e quantidade de horas
    // trabalhadas no mˆes. Por´em, para algumas fun¸c˜oes existe uma bonifica¸c˜ao.
    // Para os l´ıderes, o sal´ario ´e incrementado em 2% e para os gerentes em 5%.
    // Desenvolva o diagrama de classe da UML.

    Funcionario func = new Funcionario("funci", 100, 10);
    func.calcSalario();
    
    Gerente ger = new Gerente("ger", 100, 10);
    ger.calcSalario();

    Lider lid = new Lider("lid", 100, 10);
    lid.calcSalario();
  }
}
