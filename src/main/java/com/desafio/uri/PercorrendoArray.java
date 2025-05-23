package com.desafio.uri;

import java.util.Locale;
import java.util.Scanner;

public class PercorrendoArray {
  public static void main(String[] args) {
    // arrray de 10 elementos, mas 9 posições
    Locale.setDefault(Locale.US);
    var teclado = new Scanner(System.in);

    var N = teclado.nextInt();
    //matriz quadratica
    int[][] mat = new int[N][N];

    //percorre matriz
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        mat[i][j] = teclado.nextInt();
      }
    }

    //Imprimir matriz
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("----Diagonal principal----");
    //mostra a diagonal principal da matriz
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (mat[i][i] == mat[j][j]) {
          System.out.print(mat[i][j] + " ");
        }
      }
      System.out.println();
    }
    System.out.println("------- diagonal principal refatorada para melhor vizualização");
    //Outra forma de imprimir a diagonal principal
    for (int i = 0; i < N; i++) {
      // Adiciona 'i' espaços antes de imprimir o número
      for (int j = 0; j < i; j++) {
        System.out.print("    "); // Use 4 espaços como tabulação
      }
      System.out.println(mat[i][i]);
    }

    System.out.println("\nmostra os números negativos");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (mat[i][j] < 0) {
          System.out.print(mat[i][j] + " ");
        } else {
          System.out.print("   "); // Espaços para manter alinhamento
        }
      }
      System.out.println();
    }

    System.out.println("\nMostrar numeros positivos");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (mat[i][j] > 0) {
          System.out.print(mat[i][j] + " ");
        } else {
          System.out.print("   ");
        }
      }
      System.out.println();
    }

    // fazer codigo para medir celcius em Fahrenheit e fahrenheit em celcius

    teclado.close();
  }
}
