package com.desafio.advancedjava.interfaces;

import lombok.Getter;
import lombok.Setter;

class GerenciarCampos {

  private static String SOM_DO_CACHORRO = "Au Au";

  static void usarCampo() {
    SOM_DO_CACHORRO = "Miau";
    System.out.println(SOM_DO_CACHORRO);
  }
}

@Getter
@Setter
abstract class Cachorro {

  private String somDoCachorro;

  public Cachorro(String somDoAnimal) {
    this.somDoCachorro = somDoAnimal;
  }

  public abstract void latir();

  public abstract String latir(String somDoAnimal);

  public void brincar() {
    System.out.println("Brincando");
  }
}

sealed interface Animal permits Mamifero, Reptil, Program {

  public static final String somDoAnimal = "Animal fazendo som";

  default void comer() {
    System.out.println("Animal comendo");
  }
  abstract void comer2();
}

non-sealed interface Mamifero extends Animal {
  default void comer() {
    System.out.println("Mamifero comendo");
  }
}

non-sealed interface Reptil extends Animal {
  default void comer() {
    System.out.println("Reptil comendo");
  }
}

class Jacare implements Reptil {
  @Override
  public void comer2() {
    System.out.println("Fazendo som do reptile");
  }
  // Method comer() already implemented in the interface Reptil
}


public non-sealed class Program extends Cachorro implements Animal {
  public Program() {
    super("SOM!");
  }

  public Program(String somDoAnimal) {
    super(somDoAnimal);
  }

  @Override
  public void latir() {
    System.out.println("Au Au");
  }

  @Override
  public void comer() {
    Animal.super.comer();
  }

  @Override
  public void comer2() {

  }

  @Override
  public String latir(String somDoAnimal) {
    return somDoAnimal;
  }

  public static void main(String[] args) {
    Program p = new Program();
    p.comer();
    Reptil reptil = new Jacare();
    reptil.comer();
    reptil.comer2();
    Program cachorro = new Program();
    cachorro.latir();

    System.out.println(p.latir("AUuuuuu!"));

    System.out.println(somDoAnimal);

  }
}
