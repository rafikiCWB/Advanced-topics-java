package com.desafio.advancedjava.methodreferences;

interface Figura2D {
  void desenha(Double largura, Double altura);
}

//Observe que a classe retangulo não está implementando a interface Figura
class Retangulo {

  static final String ALTURA = " e altura: ";
  static final String LARGURA = "Desenha retângulo de largura: ";

  public Retangulo() {
  }

  public Retangulo(Double largura, Double altura) {
    System.out.println(LARGURA + largura + ALTURA + altura);
  }

  public void desenhaRetangulo(Double largura, Double altura) {
    System.out.println(LARGURA + largura + ALTURA + altura);
  }
}

//Referencia um metodo de instancia de um objeto particular
public class MethodReferencesExemplo01 {
  public static void main(String[] args) {

    Figura2D fig1 = (l, a) -> System.out.println(Retangulo.LARGURA + l + Retangulo.ALTURA + a);

    fig1.desenha(8.0, 1.5);

    //Objeto especifico
    Retangulo ret = new Retangulo();
    ret.desenhaRetangulo(10.0, 1.5);

    /*Method reference
     * Referência a um method de instância (desenhaRetangulo) de um objeto particular (ret)
     */
    Figura2D fig2 = ret::desenhaRetangulo;
    fig2.desenha(10.5, 7.0);
  }
}
