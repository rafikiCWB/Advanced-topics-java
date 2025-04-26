package com.desafio.methodreferences;

/**
 * -- Um Pouco sobre Method References
 * O operador :: introduzido no java 8 permite que você use referências a métodos de instância em vez de objetos. Pode ser utilizado em muitos casos como um bom substituto do lambda expression.
 * A expressão System.out::println é um exemplo clássico de method reference nas literaturas.
 * Assim como lambda expression, method reference também está relacionado a interfaces funcionais.
 */
public class MethodReferencesExemplo04 {

  public static void main(String[] args) {
    Figura2D fig1 = Retangulo::new;
    fig1.desenha(10.5, 7.0);
    System.out.println(fig1);
  }

}
