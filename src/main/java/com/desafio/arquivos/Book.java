package com.desafio.arquivos;

import java.util.List;

/**
 * Representa um livro com suas informações básicas.
 */
public record Book(
    String titulo,
    String autor,
    int anoPublicacao,
    String editora,
    String isbn,
    List<String> generos
) {
}