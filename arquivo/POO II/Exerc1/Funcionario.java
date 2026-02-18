// 2
// Crie um programa para calcular o sal´ario dos funcion´arios de uma
// empresa. O sal´ario ´e baseado no valor hora e quantidade de horas
// trabalhadas no mˆes. Por´em, para algumas fun¸c˜oes existe uma bonifica¸c˜ao.
// Para os l´ıderes, o sal´ario ´e incrementado em 2% e para os gerentes em 5%.
// Desenvolva o diagrama de classe da UML.

public class Funcionario {
  private String nome;
  private String cargo;
  private double valorHora;
  private int horasTrab;
  private double salario;
  private double boni;

  public Funcionario(String cargo, double valorHora, int horasTrab) {
    this.cargo = cargo;
    this.valorHora = valorHora;
    this.horasTrab = horasTrab;
    setBoni(1);
  }
  
  public void calcSalario() {
    setSalario(getValorHora() * getHorasTrab() * getBoni());
    System.out.println("Salário de " + getCargo() + " é " + getSalario());
  }
  
  // public void calcSalario2() {
  //   double boni = 1;
  //   if (this.cargo.equals("ger")) {
  //     boni = 1.05;
  //   }
  //   else if (this.cargo.equals("lid")) {
  //     boni = 1.02;
  //   }

  //   System.out.println("Sálario de " + nome + ", cargo " + cargo + ", é " + (valor_hora * horas_trab) *);
  // }

  public String getNome() {
  	return nome;
  }
  public void setNome(String nome) {
  	this.nome = nome;
  }
  public String getCargo() {
  	return cargo;
  }
  public void setCargo(String cargo) {
  	this.cargo = cargo;
  }
  public double getValorHora() {
  	return valorHora;
  }
  public void setValorHora(double valorHora) {
  	this.valorHora = valorHora;
  }
  public int getHorasTrab() {
  	return horasTrab;
  }
  public void setHorasTrab(int horasTrab) {
  	this.horasTrab = horasTrab;
  }
  public double getBoni() {
  	return boni;
  }
  public void setBoni(double boni) {
  	this.boni = boni;
  }
  public double getSalario() {
  	return salario;
  }
  public void setSalario(double salario) {
  	this.salario = salario;
  }

}