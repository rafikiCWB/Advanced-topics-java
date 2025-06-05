package com.desafio.tecnico.interviewfeitoporia;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Trocar {


  public static void main(String[] args) {
    int[] arrayDesordenado = {8, 5, 11, 24, 6, 1, 2};
//    trocar.swap(troca, 0, 1);
//    trocar.swap(troca, 2, 3);
//    System.out.println(Arrays.toString(troca));

    System.out.println("Sem estrutura e dados " + Arrays.toString(minhaOrdenacao(arrayDesordenado)));


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
}
