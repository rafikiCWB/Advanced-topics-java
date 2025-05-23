package com.desafio.advancedjava.instanciaof;

public class TesteInstanceof {
  public static void main(String[] args) {
    Animal meuAnimal = new Cachorro();
//    Cachorro dog = new Animal(); erro de compilação
    if (meuAnimal instanceof Cachorro) {
      ((Cachorro) meuAnimal).fazerSom(); // Convertemos para Cachorro e chamamos seu método específico
    } else {
      meuAnimal.fazerSom();
    }

    if (meuAnimal instanceof Cachorro cachorro) {
      cachorro.fazerSom();
    }
  }
}

class Animal {
  void fazerSom(){
    System.out.println("Som do Animal genérico");
  }
}
class Cachorro extends Animal {
  @Override
  void fazerSom() {
    System.out.println("Cachorro latindo");
  }
}
class Gato extends Animal {
  @Override
  void fazerSom() {
    System.out.println("Gato miando");
  }
}