package com.desafio.tecnico.lacrado;

public final class Square extends Shape {

  public void quadrado(int resultado) {
    tamanhoQuadrado(resultado * resultado);
  }

  public static void main(String[] args) {
    Square s = new Square();
    s.quadrado(10);
    System.out.println(s);
  }

}
