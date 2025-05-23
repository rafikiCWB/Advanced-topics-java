package com.desafio.advancedjava.lambda;

interface Figura {
  void desenha();
}

//Classe concreta implementa a interface Figura
class Circunferencia implements Figura {
  @Override
  public void desenha() {
    System.out.println("Desenhando circumference");
  }
}

public class LambdaExemplo1 {
  public static void main(String[] args) {
    //implementação sem lambda expression - utilizando classe concreta
    Circunferencia cir = new Circunferencia();
    cir.desenha();

    //implementando se lambda expression - utilizando classe anonima
    Figura fig = new Figura() {
      @Override
      public void desenha() {
        System.out.println("Interface Figura: desenhando circunference");
      }
    };
    fig.desenha();

    //Lambda expression sem argumentos
    Figura fig2 = () -> System.out.println("\nLambda Expression: Desenhando circunference");
    fig2.desenha();

    //Lambda expression sem argumentos e com multiplos metodos
    Figura fig3 = () -> {
      System.out.println("\nLambda Expression: multiple methods");
      System.out.println("Desenhando circunference");
    };
    fig3.desenha();
  }

}