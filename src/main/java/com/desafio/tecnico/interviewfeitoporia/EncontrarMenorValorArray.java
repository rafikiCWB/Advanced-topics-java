package com.desafio.tecnico.interviewfeitoporia;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EncontrarMenorValorArray {

//  public static void main(String[] args) {
//    int[] criacaoDoArray = {10, 5, 20, 3, 7,1};
//    //temp = 10  pos[0] = 5 pos[1] 10;
//    //temp = pos[0] pos[0] = pos[1] pos[i] = temp;
//    //temp = pos[j] pos[j] = pos[j+1] pos[j+1] = temp
//
//    for (int result : criacaoDoArray) {
//      System.out.println(result);
//    }
//    IntStream sorted = Arrays.stream(criacaoDoArray).sorted();
//    System.out.println("fadsfdsA: " +Arrays.toString(sorted.toArray()));
//
//    List<Integer> listaInteiros = Arrays.asList(10,12,1,5,7,3,9);
//    Collections.sort(listaInteiros);
//
//    for (Integer l : listaInteiros) {
//      System.out.println("Comparations sort :" + l);
//    }
//
//    System.out.println("O menor valor é: " + solution(criacaoDoArray));
//    System.out.println("-------------------");
//    System.out.println("Array ordenado: " + Arrays.toString(arrayOdenado(criacaoDoArray)));
//    System.out.println("----------");
//    System.out.println("Sem estrutura e dados " + Arrays.toString(minhaOrdenacao(criacaoDoArray)));
//
//  }

  private static int solution(int[] array) {
    int menorValor = array[0];

    for (int j : array) {
      if (j < menorValor) {
        menorValor = j;
      }
    }
    for (int i = 0; i < array.length; i = i + 1) {
      if (array[i] < menorValor) {
        menorValor = array[i];
      }
    }
    return menorValor;
  }

  private static int[] arrayOdenado(int[] array) {
    Arrays.sort(array);
    return array;
  }

  @Contract("_ -> param1")
  public static int[] minhaOrdenacao(@NotNull int[] array) {
    if (array.length <= 1) {
      return array;
    }

    int left = 0;
    int right = array.length - 1;

    quickSort(array, left, right);
    return array;
  }

  private static void quickSort(int[] array, int left, int right) {
    if (left < right) {
      int pivot = partition(array, left, right);
      quickSort(array, left, pivot - 1);
      quickSort(array, pivot + 1, right);
    }
  }

  private static int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int i = left - 1;

    for (int j = left; j < right; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(array, i, j);
      }
    }

    swap(array, i + 1, right);
    return i + 1;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
      array[i] = array[j]; 
      array[j] = temp;
  }

  public static void strReverse(String nome) {
//    StringBuilder sb = new StringBuilder(nome);
//    sb.reverse();
//    System.out.println(sb.toString());
    // nome = "rafael";
    for (int i = nome.length() - 1; i >= 0; i--) { //fim
      System.out.print(nome.charAt(i));
    }

  }

  public static void main(String[] args) {
    strReverse("rafael");
    soma();

    // Teste do novo método encontrarMenorValorComReduce
    System.out.println("\n--- Teste do método encontrarMenorValorComReduce ---");
    int[] arrayTeste = {10, 5, 20, 3, 7, 1, 15};
    int menorValor = encontrarMenorValorComReduce(arrayTeste);
    System.out.println("O menor valor usando reduce é: " + menorValor);

    // Comparação com o método solution existente
    System.out.println("O menor valor usando o método tradicional é: " + solution(arrayTeste));

    System.out.println("*-*-*-*-*");
    int[] arrayDesordenado = {8, 5, 11, 24, 6, 1, 2};
    System.out.println("Sem estrutura e dados " + Arrays.toString(minhaOrdenacao(arrayDesordenado)));

  }

  public static void soma() {
    var instance = new EncontrarMenorValorArray();
    List<Integer> list = Arrays.asList(1, 4, 5, 7, 2, 9, 1);
    List<String> listaStr = Arrays.asList("rafael", "grando", "java", "kotlin");//grando, java, kotlin, rafael -> rafael, kotlin, java grando
//    Collections.sort(listaStr);
    Collections.reverse(listaStr);
    System.out.println(listaStr);

    Collections.reverse(list);
    System.out.println(list);

    Integer reduce = list.stream().reduce(0, Integer::sum);
    System.out.println(reduce);

    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.print(list.get(i) + (i > 0 ? ", " : ""));
    }
    System.out.println("----------------");
    List<String> nomes = Arrays.asList("rafael", "grando", "java", "kotlin");
    List<String> nomesMaiusculo = nomes.stream().map(instance::paraMaiusculo).toList();

    System.out.println(String.join(", ", nomesMaiusculo));
    Optional<String> reduce1 = listaStr.stream().reduce(String::concat);
    System.out.println(reduce1.orElse(" "));

  }

  public String paraMaiusculo(String nome) {
    return nome.toUpperCase();
  }

  /**
   * Encontra o menor valor em um array de inteiros usando o método reduce.
   *
   * @param array O array de inteiros a ser analisado
   * @return O menor valor encontrado no array, ou Integer.MAX_VALUE se o array estiver vazio
   */
  public static int encontrarMenorValorComReduce(int[] array) {
    if (array == null || array.length == 0) {
      return Integer.MAX_VALUE; // Retorna o maior valor possível se o array for vazio ou nulo
    }

    return Arrays.stream(array)
            .boxed() // Converte IntStream para Stream<Integer>
            .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
  }

}
