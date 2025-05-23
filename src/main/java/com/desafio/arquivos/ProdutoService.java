package com.desafio.arquivos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.util.List;

public class ProdutoService {
    public static StringBuilder getModeloDelimitado(List<Product> cadastros) {
        StringBuilder conteudo = new StringBuilder();
        for (Product cadastro : cadastros) {
            conteudo.append(cadastro.nome() + ";");
            conteudo.append(cadastro.preco() + ";");
            conteudo.append(cadastro.quantidade() + ";");
            conteudo.append(System.lineSeparator());

        }
        return conteudo;
    }

    public static void escreverLayoutDelimitado(List<Product> cadastros) {
        System.out.println("***** - LAYOUT DELIMITADO - ******");
        try {
            StringBuilder conteudo = getModeloDelimitado(cadastros);
            System.out.println(conteudo.toString());
            Path arquivoDestino = Paths.get("C:\\Users\\rafae\\Downloads\\arquivosGerados\\rocket\\produtos.csv");
            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void escreverLayoutPosicional(List<Product> cadastros) throws IOException {
        System.out.println("***** - LAYOUT POSICIONAL - ******");

        try {
            StringBuilder conteudo = new StringBuilder();
            for (Product produto : cadastros) {
                String nome = produto.nome();
                nome = String.format("%-10s", nome);
//                if (nome.length() > 30) {
//                    nome = nome.substring(0, 30);
//                }
//                if (nome.length() < 30) {
//                    nome = String.format("%-10s", nome);
//                }

                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

                conteudo.append(nome);
                String valorFormatado = numberFormat.format(produto.preco());
                conteudo.append(valorFormatado.replaceAll("\\,", "\\."));
                conteudo.append("   ").append(produto.quantidade());


//            DecimalFormat decimalFormat = new DecimalFormat("#0000.00");

                // nova linha
                conteudo.append(System.lineSeparator());

            }
            System.out.println(conteudo.toString());

            Path arquivoDestino = Paths.get("C:\\Users\\rafae\\Downloads\\arquivosGerados\\rocket\\produto.txt");
            Files.writeString(arquivoDestino, conteudo.toString(), StandardOpenOption.CREATE);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}