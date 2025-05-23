package com.desafio.advancedjava.stream;

import java.util.*;

/**
 * -- Stream --
 * Oferece meios para manipular fluxos de dados em coleções via pipeline
 * Representada pelo pacote java.util.Stream.
 * É um recurso do Java 8 está intimamente ligado ao termo pipeline que na programação significa uma cadeia de operações que formam um fluxo de processamento.
 * As operações executadas por stream não afetam os dados originais. Por exemplo, filtrada uma coleção de dados, UM novo fluxo é produzido com os dados filtrados, em vez de remover os dados da coleção de origem.
 * OBS: AS classes e interfaces contidas neste pacote não se tratam de estrutura de dados e não servem para armazenar dados.
 */
//we only lost because my whole team are nobs
public class JavaStreamsExemplo {

  public static void main(String[] args) {
    List<Produto> listaProdutos = new ArrayList<>();
    listaProdutos.add(new Produto(1000, "Geladeira 470L", 2999.00));
    listaProdutos.add(new Produto(2000, "TV UHD 50''", 3500.00));
    listaProdutos.add(new Produto(1001, "TV UHD 65''", 5000.00));
    listaProdutos.add(new Produto(3000, "Microondas 20L", 399.00));
    listaProdutos.add(new Produto(1001, "Geladeira 120L", 900.00));
    listaProdutos.add(new Produto(4000, "Computador i5 2.9Ghz 4GB 1TB HD", 2429.00));
    listaProdutos.add(new Produto(1002, "Geladeira 500L", 3100.00));

    System.out.println("Usando a forma 'antiga'...");

    //Cria lista de geladeiras
    List<Produto> listaGeladeira = new ArrayList<>();
    for (Produto p : listaProdutos) {
      if (p.getNome().contains("Geladeira")) {
        listaGeladeira.add(p);
      }
    }
    System.out.println(listaGeladeira);

    System.out.println("-------------------");

    List<String> listaNomesUpper = new ArrayList<>();
    for (Produto p : listaGeladeira) {
      listaNomesUpper.add(p.getNome().toUpperCase());
    }
    listaNomesUpper.forEach(System.out::println);

    System.out.println("-------------------");

    //Ordenar lista de geladeiras por preço crescente
    Collections.sort(listaGeladeira, new OrdenarProdutoPreco());
    listaGeladeira.forEach(System.out::println);

    System.out.println("-------------------");

    //obtém o fluxo de dados (stream)
    listaProdutos.stream()
        //Interface Predicate(función com valor booleano) - filtra o nome dos produtos que contem 'Geladeira'
        .filter(p -> p.getNome().contains("Geladeira"))
        //Interface Comparator(Ordena o stream de acordo com comparator fornecido)
        .sorted((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()))
        //Interface Function(Retorna um fluxo que consiste nos resultados da aplicação da função fornecida aos elementos desse fluxo.) - Aplica uma dada função (toUpperCase) aos elementos dessa stream.
        .map(p -> p.getNome().toLowerCase())
        //Interface Consumer(Recebe um valor e não retorna nada) - Imprime os nomes dos produtos na tela.
        .forEach(System.out::println);

    System.out.println("-------------------");
  }

}
