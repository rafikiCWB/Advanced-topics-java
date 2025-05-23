package com.desafio.exercism.jedlikstoycar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JedliksToyCarTest {

  JedliksToyCar car = new JedliksToyCar();

  @Test
  void buy_new_car_returns_instance() {
    var car = JedliksToyCar.buy();
    assertThat(car).isNotNull();
  }

  @Test
  void buy_new_car_returns_new_car_each_time() {
    JedliksToyCar car1 = JedliksToyCar.buy();
    JedliksToyCar car2 = JedliksToyCar.buy();
    assertThat(car1).isNotEqualTo(car2);
  }

  @Test
  void newCarDistanceDisplay() {
//    JedliksToyCar car = new JedliksToyCar();
    assertThat(car.distanceDisplay()).isEqualTo("Driven 0 meters");
  }

  @Test
  void newCarBatteryDisplay() {
    assertThat(car.batterDisplay()).isEqualTo("Battery at " + car.batteryLevel + "%");
  }

  @Test
  void batteryDisplayZero() {
    for (int i = 0; i < 100; i++) {
      car.drive();
    }
    assertThat(car.batterDisplay()).isEqualTo("Battery empty");
  }

  @Test
  void distance_display_after_driving_multiple_times() {
    for (int i = 0; i < 5; i++) {
      car.drive();
    }
    assertThat(car.distanceDisplay()).isEqualTo("Driven 100 meters");
  }

  @Test
  void display_battery_after_driving_once() {
    car.drive();
    assertThat(car.batterDisplay()).isEqualTo("Battery at 99%");
  }

  @Test
  void atualizarPorcentagemBateriaAoDirigir() {
    for (int i = 0; i < 17; i++) {
      car.drive();
    }
    assertThat(car.batterDisplay()).isEqualTo("Battery at 83%");
  }

  @Test
  void battery_display_when_battery_empty() {
    var car = new JedliksToyCar();
    for (int i = 0; i < 100; i++) {
      car.drive();
    }
    car.drive();
    assertThat(car.batterDisplay()).isEqualTo("Battery empty");
  }

  @Test
  void distance_display_when_distance_empty() {
    for (int i = 0; i < 100; i++) {
      car.drive();
    }
    assertThat(car.distanceDisplay()).isEqualTo("Driven 2000 meters");
  }
}