package com.desafio.tecnico.interview;

public class Food {
 /* public static int solution(int N, int[][] ratings) {
    // Variáveis para armazenar o ID com maior rating e o maior rating encontrado
    int maxRating = -1; // -1 é uma forma de dizer que nenhuma nota foi encontrada
    int bestFoodId = Integer.MAX_VALUE; // è uma forma de dizer que não sei quais são os id's então estou garantindo que pdoe ser de -2bilhoes a +2bilhoes

    // Itera sobre a matriz de ratings
    for (int i = 0; i < N; i++) {
      //minha variavel foodID recebe Minha matriz na linha i com o valor na coluna 0
      //linha (i)1 posição 0
      int foodId = ratings[i][0]; // ID da comida
      //Minha matriz na linha i(por exemplo linha 0, depois linha 1, depois linha 2. etc) recebe valor na coluna 1
      //Linha (i)1 posição 1
      int rating = ratings[i][1]; // Rating da comida

      // Verifica se o rating é maior ou se o rating é igual ao encontrado,
      // mas com um ID de comida menor
      //aqui estou verificando a maior nota
      if (rating > maxRating || (rating == maxRating && foodId < bestFoodId)) {
        maxRating = rating;
        bestFoodId = foodId;
      }
    }

    // Retorna o ID da comida com o maior rating
    return bestFoodId;
  }

  public static void main(String[] args) {
    // Exemplo de teste
    int N = 5;
    int[][] ratings = {
           //C
            {5, 5},// L
            {2, 3},
            {3, 5},
            {4, 2},
            {1, 5}
    };

    // Chama a solução e exibe o resultado
    System.out.println("Comida com maior rating: " + solution(N, ratings));
  }*/

  public static void main(String[] args) {
    int N = 5;
    int[][] rating = {
            {1, 5},
            {2, 4},
            {3, 3},
            {4, 2},
            {5, 1}
    };
    System.out.println("O ID da melhor comida É... : " + solution(N, rating));

  }

  private static int solution(int N, int[][] ratings) {
    int maxRating = -1;
    int bestFoodId = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      int foodId = ratings[i][0];
      int rating = ratings[i][1];
      if (rating > maxRating || rating == maxRating && foodId < bestFoodId) {
        maxRating = rating;
        bestFoodId = foodId;
      }
    }

    return bestFoodId;
  }
}