package com.desafio.uri;


public class NumeroPrimo {
  public static void main(String[] args) {
    /*
     * Algorithm para mostrar números primos
     */
    //Se o número for divisível por 1 e ele mesmo é numero primo
//    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
//    for (int i = 0; i < numbers.length; i++) {
//      int number = numbers[i];
//      System.out.println(number + " é " + (isPrime(number) ? "primo" : "não primo"));
//    }

    System.out.println(isPrime(11));
  }
  private static boolean isPrime(int number) {
    if (number <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
