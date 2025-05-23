package com.desafio.arquivos.json;

import java.util.List;

public record Pessoa(
    String nome,
    int idade,
    String email,
    List<String> hibbies
) {

  @Override
  public String nome() {
    return nome;
  }

}
