package com.desafio.uri;

public class DiasEmAnos {

  public static void main(String[] args) {
    int diasEmAnos = 769;
    int dia, mes, ano, resto;

    ano = diasEmAnos / 365; //1
    resto = diasEmAnos % 365; // 35
    mes = resto / 30; // 5
    dia = resto % 30; // 1
    System.out.println(diasEmAnos +"dias tem: " + ano + "ano(s) " + mes + "mes(s) " + dia + "dia(s)");

  }
}
