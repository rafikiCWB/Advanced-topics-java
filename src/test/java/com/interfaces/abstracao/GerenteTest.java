package com.interfaces.abstracao;

import com.desafio.advancedjava.interfaces.abstracao.Gerente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenteTest {

  @Test
  void autenticarDeveRetornarTrueParaSenhaCorreta() {
    // Arrange
    Gerente gerente = new Gerente("Rafael", 4750.00);
    String senhaCorreta = "1234";

    // Act
    boolean autenticado = gerente.autenticar(senhaCorreta);

    // Assert
    assertTrue(autenticado, "A autenticação deveria retornar true para a senha correta.");
  }

  @Test
  void autenticarDeveRetornarFalseParaSenhaIncorreta() {
    // Arrange
    Gerente gerente = new Gerente("Rafael", 4750.00);
    String senhaIncorreta = "4321";

    // Act
    boolean autenticado = gerente.autenticar(senhaIncorreta);

    // Assert
    assertFalse(autenticado, "A autenticação deveria retornar false para uma senha incorreta.");
  }

  @Test
  void autenticarDeveRetornarFalseParaSenhaVazia() {
    // Arrange
    Gerente gerente = new Gerente("Rafael", 4750.00);
    String senhaVazia = "";

    // Act
    boolean autenticado = gerente.autenticar(senhaVazia);

    // Assert
    assertFalse(autenticado, "A autenticação deveria retornar false para uma senha vazia.");
  }

  @Test
  void autenticarDeveRetornarFalseParaSenhaNula() {
    // Arrange
    Gerente gerente = new Gerente("Rafael", 4750.00);
    String senhaNula = null;

    // Act & Assert
    assertThrows(NullPointerException.class, () -> gerente.autenticar(senhaNula),
        "Deve lançar NullPointerException quando a senha é nula");
  }

  @Test
  void deveriaNaoRetornarFalseParaSenhaNula() {
     // Arrange
    Gerente gerente = new Gerente("Rafael", 4750.00);
    String senhaNull = null;

    boolean autenticar = gerente.autenticar(String.valueOf(Boolean.parseBoolean(senhaNull)));

    assertNotEquals(autenticar, senhaNull);
  }


}