package com.desafio.advancedjava.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Exemplo {

  public static void main(String[] args) {

    try {
      String texto = "A clase base64";
      System.out.println(texto);

      String textoCodificado = Base64.getEncoder().encodeToString(texto.getBytes());
      System.out.println(textoCodificado);

      String textoDecodificado = new String(Base64.getDecoder().decode(textoCodificado), StandardCharsets.UTF_8);
      System.out.println(textoDecodificado);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}