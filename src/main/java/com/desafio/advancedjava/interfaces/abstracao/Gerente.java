package com.desafio.advancedjava.interfaces.abstracao;

/**
 * Abstract classes são para compartilhar código, interfaces para definir contratos flexíveis."
 */
final class App {
  public static void main(String[] args) {
    Gerente gerente = new Gerente("Rafael", 4750.00);
    System.out.println(gerente.autenticar("1234"));
    gerente.calcularBonus();
  }
}

public class Gerente extends Funcionario implements Autenticavel {
  public Gerente(String nome, double salario) {
    super(nome, salario);
  }

  //autenticar a senha do gerente
  @Override
  public boolean autenticar(String senha) {
    boolean autenticaSenha = senha.equals("1234");
    return autenticaSenha;
  }

  // calcular bônus de gerente
  @Override
  public void calcularBonus() {
    System.out.println("O bônus do gerente é: " + (this.salario * 0.2));
  }
}

interface Autenticavel {
  default boolean autenticar(String senha) {
    return false;
  }
}

abstract class Funcionario {
  public String nome;
  public double salario;

  public Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
  }

  public abstract void calcularBonus();
}

