package com.desafio.uri;

import java.util.Scanner;

/**
 * Leia um valor inteiro X e imprima os 6 números ímpares consecutivos de X,
 * um valor por linha, incluindo X se for o caso.
 * Entrada deve ser um número posítivo. Ex 8
 * A saída deve ser 9 11 13 15 17 19
 */
public class Uri1070 {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    int numero = teclado.nextShort();
    int contador = 0;
    int numeroAtual = numero;

    if (numero % 2 != 0) {
      println(numero);
    }

    while (contador < 6) {
     if (numeroAtual % 2 != 0) {
        System.out.println(numeroAtual);
        contador++;
      }
      numeroAtual++;
    }


    teclado.close();
  }

  public static void println(Object message) {
    System.out.println(message);
  }
}
