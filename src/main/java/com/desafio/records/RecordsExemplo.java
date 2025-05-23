package com.desafio.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class Produto {
  private String nomeProduto; // variável de instância

  public String getNomeProduto() {
    return nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }
//  public String setNomeProduto(String nomeProduto) {
//    return this.nomeProduto = nomeProduto;
//  }

  public static void main(String[] args) {
    var p = new Produto();
    p.setNomeProduto("Monitor");
    System.out.println(p.getNomeProduto());
  }

  @Override
  public String toString() {
    return "Produto{" +
            "nomeProduto='" + nomeProduto + '\'' +
            '}';
  }
}


interface Pessoa {
  Usuario dadosPessoa();
}


record Usuario(Long UUID,
               String nome) {

}

// records permite implements interfaces mas não permite extends classes
public record RecordsExemplo(LocalDateTime getDate, BigDecimal getSalario) implements Pessoa {
  //  private String nome; // não é permitido variaveis de instância
  static final double number = 1.2D; // todos os atributos em RECORDS são definidos como static final

  static Long id = 1L;

  Long imprimirID() {
    return id = 3L;
  }

  @Override
  public LocalDateTime getDate() { // posso ter os get's mas não posso ter os sets, pq os atributos em records são static final
    return getDate;
  }

  @Override
  public BigDecimal getSalario() {
    return getSalario;
  }

  @Override
  public Usuario dadosPessoa() {
    int x = 1;
    return new Usuario(41564564L, "Rafael");
  }

}

class testRecord {
  public static void main(String[] args) {
    var registro = new RecordsExemplo(LocalDateTime.now(), new BigDecimal("4975.00"));
    System.out.println(registro);
    System.out.println("----------");

    double number = registro.number;
    Long id = RecordsExemplo.id = 2L;
    System.out.println(id);

    Usuario showUser = registro.dadosPessoa();
    System.out.println(showUser);

    System.out.println("----------");
    System.out.println(registro.imprimirID());

  }
}
