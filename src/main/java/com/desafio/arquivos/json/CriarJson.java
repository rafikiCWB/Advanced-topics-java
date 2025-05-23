package com.desafio.arquivos.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CriarJson {
  public static void main(String[] args) {
    try {
      // Criando um ObjectMapper
      ObjectMapper mapper = new ObjectMapper();
      ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

      // Método 1: Usando Map
      Map<String, Object> dados = new HashMap<>();
      dados.put("nome", "João");
      dados.put("idade", 30);
      dados.put("email", "joao@email.com");
      dados.put("hobbies", Arrays.asList("ler", "viajar", "música"));
      // Salvando o arquivo JSON
      writer.writeValue(new File("C:\\Users\\rafae\\Downloads\\arquivosGerados\\dados.json"), dados);

      System.out.println("Método 2: usando uma classe POJO");
      var pessoa = new Pessoa(
              "Bilbo",
              111,
              "Bilbo@hobit.com",
              Arrays.asList("leitura", "viagem", "musica"));
      writer.writeValue(new File("C:\\Users\\rafae\\Downloads\\arquivosGerados\\pessoa.json"), pessoa);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
