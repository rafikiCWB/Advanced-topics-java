package com.desafio.functionalinterface;

// Interface para demonstrar o uso de classe anônima
interface Animal {
  void fazerSom();

  void mover();
}

public class ClasseAnonima {
  public static void main(String[] args) {
    // Criando uma classe anônima que implementa a interface Animal
    Animal cachorro = new Animal() {
      private String nome = "Rex";

      @Override
      public void fazerSom() {
        System.out.println("Au au!");
      }

      @Override
      public void mover() {
        System.out.println("Cachorro correndo...");
      }

      // Método adicional específico desta implementação anônima
      private void abanarRabo() {
        System.out.println(nome + " está abanando o rabo!");
      }
    };

    // Usando a classe anônima
    cachorro.fazerSom();
    cachorro.mover();

    // Criando outra classe anônima que implementa Animal
    Animal gato = new Animal() {
      @Override
      public void fazerSom() {
        System.out.println("Miau!");
      }

      @Override
      public void mover() {
        System.out.println("Gato se esgueirando...");
      }
    };

    // Usando a segunda classe anônima
    gato.fazerSom();
    gato.mover();

    // Exemplo com Runnable (comum em threads)
    Runnable tarefa = new Runnable() {
      @Override
      public void run() {
        System.out.println("Executando tarefa em classe anônima");
      }
    };

    // Executando a tarefa
    new Thread(tarefa).start();

    // Classe anônima criada diretamente como argumento
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Outra tarefa em classe anônima");
      }
    }).start();
  }

  // Método que recebe uma classe anônima como parâmetro
  public static void executarComportamentoAnimal(Animal animal) {
    animal.fazerSom();
    animal.mover();
  }
}
