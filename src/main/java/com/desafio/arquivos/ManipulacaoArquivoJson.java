package com.desafio.arquivos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Classe para manipulação de arquivos JSON de livros.
 */
public class ManipulacaoArquivoJson {

    private static final String DIRETORIO_JSON = "C:\\Users\\rafae\\Downloads\\arquivosGerados\\json";
    private static final String ARQUIVO_JSON = DIRETORIO_JSON + "\\livros.json";
    
    /**
     * Cria um arquivo JSON com uma lista de livros.
     * @throws IOException se ocorrer um erro ao criar o arquivo
     */
    public void criarArquivoJsonLivros() throws IOException {
        // Garantir que o diretório existe
        File diretorio = new File(DIRETORIO_JSON);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
        
        // Criar lista de livros
        List<Book> livros = Arrays.asList(
            new Book(
                "Dom Casmurro",
                "Machado de Assis",
                1899,
                "Garnier",
                "9788525406262",
                Arrays.asList("Romance", "Literatura Brasileira", "Clássico")
            ),
            new Book(
                "O Senhor dos Anéis: A Sociedade do Anel",
                "J.R.R. Tolkien",
                1954,
                "HarperCollins",
                "9788595084759",
                Arrays.asList("Fantasia", "Aventura", "Épico")
            ),
            new Book(
                "1984",
                "George Orwell",
                1949,
                "Companhia das Letras",
                "9788535914849",
                Arrays.asList("Ficção Científica", "Distopia", "Política")
            ),
            new Book(
                "Memórias Póstumas de Brás Cubas",
                "Machado de Assis",
                1881,
                "Principis",
                "9788580028270",
                Arrays.asList("Romance", "Literatura Brasileira", "Realismo")
            )
        );
        
        // Criar e configurar o ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        
        // Salvar o arquivo JSON
        writer.writeValue(new File(ARQUIVO_JSON), livros);
        
        System.out.println("Arquivo JSON de livros criado com sucesso em: " + ARQUIVO_JSON);
    }
    
    /**
     * Lê o arquivo JSON de livros e exibe seu conteúdo no console.
     * @throws IOException se ocorrer um erro ao ler o arquivo
     */
    public void lerArquivoJsonLivros() throws IOException {
        File arquivo = new File(ARQUIVO_JSON);
        
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + ARQUIVO_JSON);
            return;
        }
        
        // Criar e configurar o ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        
        // Ler o arquivo JSON
        Book[] livros = mapper.readValue(arquivo, Book[].class);
        
        // Exibir o conteúdo no console
        System.out.println("=== LIVROS CADASTRADOS ===");
        for (Book livro : livros) {
            System.out.println("\nTítulo: " + livro.titulo());
            System.out.println("Autor: " + livro.autor());
            System.out.println("Ano de Publicação: " + livro.anoPublicacao());
            System.out.println("Editora: " + livro.editora());
            System.out.println("ISBN: " + livro.isbn());
            System.out.println("Gêneros: " + String.join(", ", livro.generos()));
            System.out.println("-------------------------");
        }
    }
    
    public static void main(String[] args) {
        try {
            ManipulacaoArquivoJson manipulador = new ManipulacaoArquivoJson();
            
            // Criar o arquivo JSON
            manipulador.criarArquivoJsonLivros();
            
            System.out.println("\n");
            
            // Ler e exibir o conteúdo do arquivo JSON
            manipulador.lerArquivoJsonLivros();
            
        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}