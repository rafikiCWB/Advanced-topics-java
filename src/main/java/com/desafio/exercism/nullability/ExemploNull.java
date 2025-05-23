package com.desafio.exercism.nullability;

import com.desafio.advancedjava.stream.Produto;

import java.math.BigDecimal;
import java.util.Date;

public class ExemploNull {

  public static void main(String[] args) {
    String str = "";
    System.out.println(str.getClass().getTypeName());


    BigDecimal bd = new BigDecimal(1);
    System.out.println(bd.getClass().getTypeName());

    Double dobro = 100.00D;
    System.out.println(dobro.getClass().getTypeName());

    Date date = new Date();
    System.out.println(date.getClass().getTypeName());

    Produto p = new Produto(1,"", 123D);
    System.out.println(p.getClass().getTypeName());

    Integer number = null;
    System.out.println(number);

    Produto p1 = null;



  }
}
