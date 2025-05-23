package com.desafio.advancedjava.functionalinterface;

@FunctionalInterface
public interface InterfaceFunctional  {
  void fazQualquerCoisa(String facaAlgo);

  default void fazQualquerCoisa2() {
    System.out.println("Faz qualquer coisa 2");
  }

  static void fazQualquerCoisa3() {
    System.out.println("Faz qualquer coisa 3");
  }
}
