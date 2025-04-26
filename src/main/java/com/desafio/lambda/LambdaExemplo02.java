package com.desafio.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Produto {
  private String nome;
  private Double preco;

  public Produto(String nome, Double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }
}

/**
 * Lambda Expression são Formas de escrever códigos mais funcionais e otimizados. São funções anônimas, ou seja, que não tem nome e não pertencem diretamente a nenhuma class. Lambda Expression introduzio um novo operador à linguagem java, conhecido por arrow ->. Lambda Expressions podem conter argumentos na sua declaração.
 */
public class LambdaExemplo02 {
  public static void main(String[] args) {
    List<Produto> lista = new ArrayList<>();

    lista.add(new Produto("Tv 42'", 2000.00));
    lista.add(new Produto("Geladeira 470L'", 3200.00));
    lista.add(new Produto("Fogão 4 bocas'", 900.00));
    lista.add(new Produto("Videogame'", 1999.00));
    lista.add(new Produto("Microondas'", 550.00));


    // lambda expression com um argumento
    lista.forEach((p) -> System.out.println(p.getNome() + " = " + p.getPreco()));

    System.out.println("==============================");

    //Lambda expression com dois argumentos
    lista.sort((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));

    //other way to do it Lambda expression
    lista.sort(Comparator.comparing(Produto::getPreco));

    lista.forEach((p) -> System.out.println(p.getNome() + " = " + p.getPreco()));

  }
}
