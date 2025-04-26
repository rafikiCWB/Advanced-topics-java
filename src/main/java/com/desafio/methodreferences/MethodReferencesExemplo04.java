package com.desafio.methodreferences;

public class MethodReferencesExemplo04 {

  public static void main(String[] args) {
    Figura2D fig1 = Retangulo::new;
    fig1.desenha(10.5, 7.0);
    System.out.println(fig1);
  }

}
