package com.desafio.tecnico.lacrado;

public sealed class Shape permits Square, Rectangle {

  private int tamanho;

  public void tamanhoQuadrado(int tamanho) {
    if (tamanho <= 0) {
      throw new IllegalArgumentException("Tamanho deve ser maior que zero");
    } else {
      this.tamanho = tamanho;
    }
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  @Override
  public String toString() {
    return "Shape{" +
        "tamanho=" + tamanho +
        '}';
  }
}
