package com.desafio.arquivos.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Classe responsável por gerar arquivos ZIP.
 * Permite compactar arquivos individuais, múltiplos arquivos ou diretórios completos.
 */
public class GeradorArquivoZip {
    // Diretório padrão para salvar os arquivos ZIP gerados
    private static final String OUTPUT_DIR = "C:\\Users\\rafae\\Downloads\\arquivosGerados\\zip";

    /**
     * Método principal para demonstração do uso da classe
     */
    public static void main(String[] args) {
        try {
            // Criar diretório de saída se não existir
            criarDiretorioSaida();

            // Exemplo: Compactar um arquivo .txx
            File arquivoOrigem = new File("C:\\Users\\rafae\\Downloads\\arquivosGerados\\zip\\exemplo.txx");
            if (arquivoOrigem.exists()) {
                compactarArquivo(arquivoOrigem, "exemplo_compactado.zip");
                System.out.println("Arquivo exemplo.txx compactado com sucesso!");
            } else {
                // Se o arquivo específico não existir, criar um arquivo de exemplo para demonstração
                File arquivoExemplo = new File("exemplo.txx");
                try (FileOutputStream fos = new FileOutputStream(arquivoExemplo)) {
                    fos.write("Este é um arquivo de exemplo para compactação.".getBytes());
                }
                compactarArquivo(arquivoExemplo, "exemplo_compactado.zip");
                System.out.println("Arquivo de exemplo criado e compactado com sucesso!");
                // Limpar o arquivo de exemplo após a compactação
                arquivoExemplo.delete();
            }

            System.out.println("Processo de compactação concluído. O arquivo ZIP foi salvo em: " + OUTPUT_DIR);

        } catch (IOException e) {
            System.err.println("Erro ao compactar arquivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Cria o diretório de saída se ele não existir
     * 
     * @throws IOException se ocorrer um erro ao criar o diretório
     */
    private static void criarDiretorioSaida() throws IOException {
        Path diretorio = Paths.get(OUTPUT_DIR);
        if (!Files.exists(diretorio)) {
            Files.createDirectories(diretorio);
        }
    }

    /**
     * Compacta um único arquivo em um arquivo ZIP
     * 
     * @param arquivo Arquivo a ser compactado
     * @param nomeArquivoZip Nome do arquivo ZIP a ser gerado
     * @throws IOException se ocorrer um erro durante a compactação
     */
    public static void compactarArquivo(File arquivo, String nomeArquivoZip) throws IOException {
        if (!arquivo.exists()) {
            throw new IOException("Arquivo não encontrado: " + arquivo.getAbsolutePath());
        }

        // Criar diretório de saída se não existir
        criarDiretorioSaida();

        // Caminho completo do arquivo ZIP de saída
        String caminhoArquivoZip = OUTPUT_DIR + File.separator + nomeArquivoZip;

        try (FileOutputStream fos = new FileOutputStream(caminhoArquivoZip);
             ZipOutputStream zos = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(arquivo)) {

            // Criar uma entrada ZIP para o arquivo
            ZipEntry zipEntry = new ZipEntry(arquivo.getName());
            zos.putNextEntry(zipEntry);

            // Transferir o conteúdo do arquivo para o ZIP
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            // Fechar a entrada atual
            zos.closeEntry();
        }
    }

    /**
     * Compacta múltiplos arquivos em um único arquivo ZIP
     * 
     * @param arquivos Lista de arquivos a serem compactados
     * @param nomeArquivoZip Nome do arquivo ZIP a ser gerado
     * @throws IOException se ocorrer um erro durante a compactação
     */
    public static void compactarMultiplosArquivos(List<File> arquivos, String nomeArquivoZip) throws IOException {
        // Verificar se a lista de arquivos não está vazia
        if (arquivos == null || arquivos.isEmpty()) {
            throw new IOException("Lista de arquivos vazia");
        }

        // Criar diretório de saída se não existir
        criarDiretorioSaida();

        // Caminho completo do arquivo ZIP de saída
        String caminhoArquivoZip = OUTPUT_DIR + File.separator + nomeArquivoZip;

        try (FileOutputStream fos = new FileOutputStream(caminhoArquivoZip);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Adicionar cada arquivo ao ZIP
            for (File arquivo : arquivos) {
                if (arquivo.exists()) {
                    adicionarAoZip(arquivo, arquivo.getName(), zos);
                } else {
                    System.out.println("Arquivo ignorado (não existe): " + arquivo.getAbsolutePath());
                }
            }
        }
    }

    /**
     * Compacta um diretório inteiro em um arquivo ZIP, incluindo subdiretórios
     * 
     * @param diretorio Diretório a ser compactado
     * @param nomeArquivoZip Nome do arquivo ZIP a ser gerado
     * @throws IOException se ocorrer um erro durante a compactação
     */
    public static void compactarDiretorio(File diretorio, String nomeArquivoZip) throws IOException {
        // Verificar se o diretório existe
        if (!diretorio.exists() || !diretorio.isDirectory()) {
            throw new IOException("Diretório não encontrado: " + diretorio.getAbsolutePath());
        }

        // Criar diretório de saída se não existir
        criarDiretorioSaida();

        // Caminho completo do arquivo ZIP de saída
        String caminhoArquivoZip = OUTPUT_DIR + File.separator + nomeArquivoZip;

        try (FileOutputStream fos = new FileOutputStream(caminhoArquivoZip);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Adicionar o conteúdo do diretório ao ZIP
            adicionarDiretorioAoZip(diretorio, "", zos);
        }
    }

    /**
     * Adiciona um arquivo ao ZIP
     * 
     * @param arquivo Arquivo a ser adicionado
     * @param nomeEntrada Nome da entrada no ZIP
     * @param zos Stream de saída do ZIP
     * @throws IOException se ocorrer um erro durante a adição
     */
    private static void adicionarAoZip(File arquivo, String nomeEntrada, ZipOutputStream zos) throws IOException {
        // Pular diretórios
        if (arquivo.isDirectory()) {
            return;
        }

        try (FileInputStream fis = new FileInputStream(arquivo)) {
            // Criar uma entrada ZIP para o arquivo
            ZipEntry zipEntry = new ZipEntry(nomeEntrada);
            zos.putNextEntry(zipEntry);

            // Transferir o conteúdo do arquivo para o ZIP
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            // Fechar a entrada atual
            zos.closeEntry();
        }
    }

    /**
     * Adiciona um diretório e seu conteúdo ao ZIP recursivamente
     * 
     * @param diretorio Diretório a ser adicionado
     * @param caminhoPai Caminho pai dentro do ZIP
     * @param zos Stream de saída do ZIP
     * @throws IOException se ocorrer um erro durante a adição
     */
    private static void adicionarDiretorioAoZip(File diretorio, String caminhoPai, ZipOutputStream zos) throws IOException {
        // Obter a lista de arquivos e subdiretórios
        File[] arquivos = diretorio.listFiles();

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                // Construir o caminho relativo dentro do ZIP
                String caminhoEntrada = caminhoPai.isEmpty() ? 
                        arquivo.getName() : caminhoPai + "/" + arquivo.getName();

                if (arquivo.isDirectory()) {
                    // Se for um diretório, adicionar uma entrada para ele e processar seu conteúdo
                    ZipEntry zipEntry = new ZipEntry(caminhoEntrada + "/");
                    zos.putNextEntry(zipEntry);
                    zos.closeEntry();

                    // Processar o conteúdo do subdiretório recursivamente
                    adicionarDiretorioAoZip(arquivo, caminhoEntrada, zos);
                } else {
                    // Se for um arquivo, adicioná-lo ao ZIP
                    adicionarAoZip(arquivo, caminhoEntrada, zos);
                }
            }
        }
    }

    /**
     * Define um diretório de saída personalizado para os arquivos ZIP
     * 
     * @param diretorioSaida Caminho completo do diretório de saída
     * @return O diretório de saída atualizado
     * @throws IOException se ocorrer um erro ao criar o diretório
     */
    public static String definirDiretorioSaida(String diretorioSaida) throws IOException {
        Path diretorio = Paths.get(diretorioSaida);
        if (!Files.exists(diretorio)) {
            Files.createDirectories(diretorio);
        }
        return diretorioSaida;
    }
}
