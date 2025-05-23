package com.desafio.tecnico.interviewfeitoporia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class EncontrarMenorValorArray {

  public static void main(String[] args) {
    int criacaoDoArray[] = {10, 5, 20, 3, 7,1};
    //temp = 10  pos[0] = 5 pos[1] 10;
    //temp = pos[0] pos[0] = pos[1] pos[i] = temp;
    //temp = pos[j] pos[j] = pos[j+1] pos[j+1] = temp

    for (int result : criacaoDoArray) {
      System.out.println(result);
    }
    IntStream sorted = Arrays.stream(criacaoDoArray).sorted();
    System.out.println("fadsfdsA: " +Arrays.toString(sorted.toArray()));

    List<Integer> listaInteiros = Arrays.asList(10,12,1,5,7,3,9);
    Collections.sort(listaInteiros);

    for (Integer l : listaInteiros) {
      System.out.println("Comparations sort :" + l);
    }

    System.out.println("O menor valor é: " + solution(criacaoDoArray));
    System.out.println("-------------------");
    System.out.println("Array ordenado: " + Arrays.toString(arrayOdenado(criacaoDoArray)));
    System.out.println("----------");
    System.out.println("Sem estrutura e dados " + Arrays.toString(minhaOrdenacao(criacaoDoArray)));

  }

  private static int solution(int[] array) {
    int menorValor = array[0];

    for (int j : array) {
      if(j < menorValor) {
        menorValor=j;
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

  public static int[] minhaOrdenacao(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        int temp = array[i]; //posicao atual
        array[i] = array[i + 1];//proxima posiçao
        array[i + 1] = temp;
      }
    }
    return array;
  }


}
