package com.desafio.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class LeituraDeArquivos {

    public static final String ARQUIVO = "C:\\Users\\rafae\\Downloads\\arquivosGerados\\desafio\\surprise.txt";

    public void lerArquivo(String caminho) throws FileNotFoundException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(caminho);
            int c;
            while ((c = file.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public void numeroTotalDeCaractererNoArquivo() throws IOException {
        try {
            File file = new File(ARQUIVO);
            long size = Files.size(file.toPath());
            System.out.println(size);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public void numeroTotalDePalavras() throws IOException {
        File file = new File(ARQUIVO);
        long count = Files.lines(file.toPath()).count();
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        var leitura = new LeituraDeArquivos();
        leitura.lerArquivo(ARQUIVO);
        System.out.println("\n\n" + leitura);

        System.out.println("---------------");
        leitura.numeroTotalDeCaractererNoArquivo();

        System.out.println("------------------");
        leitura.numeroTotalDePalavras();

        System.out.println("-----------------");
        leitura.numeroDeOcorrencias("rafaeL");


    }

    private void numeroDeOcorrencias(String arquivo) throws FileNotFoundException {
        File file = null;
        try {
            file = new File(ARQUIVO);
            long exists = Files.lines(file.toPath()).filter(
                    line -> line.toLowerCase().contains(arquivo.toLowerCase()) ||
                            line.toUpperCase().contains(arquivo.toUpperCase()) ||
                            line.equalsIgnoreCase(arquivo)).count();
            System.out.println(exists);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }


}
