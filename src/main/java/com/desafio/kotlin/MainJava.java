package com.desafio.kotlin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainJava {
  public static void main(String[] args) {
    List<PersonKotlin> pk = new ArrayList<>();
//    pk.add(new PersonKotlin("John Doe", 28, LocalDate.of(1996, 6, 21)));
//    pk.add(new PersonKotlin("Jane Smith", 21, LocalDate.of(1996, 6, 21)));
    pk.add(new PersonKotlin("Jane Doe", 21, LocalDate.of(1996, 6, 21)));
    pk.forEach(System.out::println);

    Date date = new Date();
    System.out.println(date);

    LocalDate localDate =  LocalDate.now();
    System.out.println(localDate);
  }
}
