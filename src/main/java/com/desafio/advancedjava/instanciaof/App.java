package com.desafio.advancedjava.instanciaof;

public class App {
  public static void main(String[] args) {
    var math = new App();
    double c = math.calcularArea(new Circle(10));
    double r = math.calcularArea(new Rectangle(10, 5));
    double t = math.calcularArea(new Triangle(10, 5));
    System.out.println("Circulo " + c);
    System.out.println("Retângulo " + r);
    System.out.println("Triangulo " + t);

  }

  public double calcularArea(Shape shape) {
    return switch (shape) {
      case Circle(double r) -> Math.PI * r * r;
      case Rectangle(double l, double w) -> l * w;
      case Triangle(double b, double h) -> (b * h) / 2;
    };
  }
}
sealed interface Shape permits Circle, Rectangle, Triangle {
  default String name() {
    return this.getClass().getSimpleName();
  }
}

record Circle(double radius) implements Shape { }
record Rectangle(double width, double height) implements Shape { }
record Triangle(double base, double height) implements Shape { }

