package com.desafio.advancedjava.instanciaof;

/**
 * O operador instanceof é muito útil para evitar erros de tipo e para garantir que você está trabalhando com o tipo de objeto esperado em tempo de execução.
 */
public class InstanceOf {

  public void metodoNovo(Object obj) {
    if (obj instanceof String) {
      System.out.println(obj.toString().toUpperCase());
    }
  }

  public static void main(String[] args) {
    var i = new InstanceOf();
    i.metodoNovo("rafael");
    i.tipoDeObjeto(999L);

    i.classificarNumero(10);
  }

  public String tipoDeObjeto(Object obj) {
    String result = switch (obj) {
      case String s -> "Eh uma String de tamanho: " + s.length();
      case Integer i -> "Eh um Integer com valor: " + i;
      case Long l -> "Eh um long com valor: " + l;
      case null -> "Eh null";
      default -> "Outro tipo: " + obj.getClass().getCanonicalName();
    };
    System.out.println(result);
    return result;
  }

  public String classificarNumero(Object obj) {
    String result = switch (obj) {
      case Integer i when i < 0 -> "Número negativo";
      case Integer i when i > 0 -> "Número positivo";
      case Integer i -> "Zero";
      default -> "Não é um número";
    };
    System.out.println(result);
    return result;
  }
}