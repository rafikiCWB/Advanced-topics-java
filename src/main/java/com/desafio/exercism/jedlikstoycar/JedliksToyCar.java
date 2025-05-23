package com.desafio.exercism.jedlikstoycar;

public class JedliksToyCar {

  public static void main(String[] args) {
    var car = new JedliksToyCar();
    car.drive();
    car.drive();
    System.out.println(car.distanceDisplay());
    System.out.println(car.batterDisplay());

  }

  int batteryLevel = 100;
  int distance = 0;

  public static JedliksToyCar buy() {
    return new JedliksToyCar(); // nova instancia de carro
  }

  // mostrar distancia percorrida
  public String distanceDisplay() {
    if (distance >= 2000) {
      return "Driven 2000 meters";
    } else {
      return String.format("Driven " + distance + " meters");
    }
  }

  //mostrar porcentagem da bateria
  public String batterDisplay() {
    if (batteryLevel == 0) {
      return "Battery empty";
    } else {
      return "Battery at " + batteryLevel + "%";
    }
  }

  //drive() para cada 20 metros -1% de bateria
  public void drive() {
    if (batteryLevel > 0) {
      distance += 20;
      batteryLevel -= 1;
    }
  }
}

