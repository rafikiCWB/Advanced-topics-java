package com.desafio.arquivos.testes;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class GerarArquivoExcel {
  private static final String OUTPUT_DIR = "C:\\Users\\rafae\\Downloads\\arquivosGerados";

  public static void main(String[] args) {
    // Criar dados de exemplo para o relatório
    List<Produto> produtos = criarDadosExemplo();

    // Gerar o arquivo Excel
    gerarRelatorioExcel(produtos, "relatorio_produtos.xlsx");

    System.out.println("Relatório Excel gerado com sucesso!");
  }

  /**
   * Gera um relatório Excel com os dados dos produtos
   *
   * @param produtos    Lista de produtos para incluir no relatório
   * @param nomeArquivo Nome do arquivo Excel a ser gerado
   */
  public static void gerarRelatorioExcel(List<Produto> produtos, String nomeArquivo) {
    try (Workbook workbook = new XSSFWorkbook()) {
      // Criar uma planilha
      Sheet sheet = workbook.createSheet("Relatório de Produtos");

      // Criar estilos para o cabeçalho
      CellStyle headerStyle = workbook.createCellStyle();
      Font headerFont = workbook.createFont();
      headerFont.setBold(true);
      headerFont.setFontHeightInPoints((short) 12);
      headerStyle.setFont(headerFont);
      headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
      headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

      // Criar a linha de cabeçalho
      Row headerRow = sheet.createRow(0);
      String[] colunas = {"ID", "Nome", "Descrição", "Preço", "Quantidade", "Data Cadastro"};

      // Preencher o cabeçalho
      for (int i = 0; i < colunas.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(colunas[i]);
        cell.setCellStyle(headerStyle);
      }

      // Criar estilo para células de data
      CellStyle dateStyle = workbook.createCellStyle();
      CreationHelper createHelper = workbook.getCreationHelper();
      dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

      // Criar estilo para células de preço
      CellStyle currencyStyle = workbook.createCellStyle();
      currencyStyle.setDataFormat(createHelper.createDataFormat().getFormat("R$ #,##0.00"));

      // Preencher os dados
      int rowNum = 1;
      for (Produto produto : produtos) {
        Row row = sheet.createRow(rowNum++);

        row.createCell(0).setCellValue(produto.getId());
        row.createCell(1).setCellValue(produto.getNome());
        row.createCell(2).setCellValue(produto.getDescricao());

        Cell precoCell = row.createCell(3);
        precoCell.setCellValue(produto.getPreco());
        precoCell.setCellStyle(currencyStyle);

        row.createCell(4).setCellValue(produto.getQuantidade());

        Cell dataCell = row.createCell(5);
        dataCell.setCellValue(produto.getDataCadastro());
        dataCell.setCellStyle(dateStyle);
      }

      // Ajustar largura das colunas automaticamente
      for (int i = 0; i < colunas.length; i++) {
        sheet.autoSizeColumn(i);
      }

      // Criar diretório se não existir
      File dir = new File(OUTPUT_DIR);
      if (!dir.exists()) {
        dir.mkdirs();
      }

      // Escrever o arquivo
      try (FileOutputStream fileOut = new FileOutputStream(new File(dir, nomeArquivo))) {
        workbook.write(fileOut);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Cria uma lista de produtos de exemplo para o relatório
   *
   * @return Lista de produtos
   */
  private static List<Produto> criarDadosExemplo() {
    List<Produto> produtos = new ArrayList<>();

    produtos.add(new Produto(1, "Notebook", "Notebook Dell Inspiron", 3500.99, 10, new Date()));
    produtos.add(new Produto(2, "Smartphone", "iPhone 13 Pro", 5999.99, 15, new Date()));
    produtos.add(new Produto(3, "Monitor", "Monitor LG 27 polegadas", 1200.50, 20, new Date()));
    produtos.add(new Produto(4, "Teclado", "Teclado Mecânico RGB", 350.00, 30, new Date()));
    produtos.add(new Produto(5, "Mouse", "Mouse Gamer", 120.00, 40, new Date()));

    return produtos;
  }

  /**
   * Classe interna para representar um produto
   */
  static class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private Date dataCadastro;

    public Produto(int id, String nome, String descricao, double preco, int quantidade, Date dataCadastro) {
      this.id = id;
      this.nome = nome;
      this.descricao = descricao;
      this.preco = preco;
      this.quantidade = quantidade;
      this.dataCadastro = dataCadastro;
    }

    public int getId() {
      return id;
    }

    public String getNome() {
      return nome;
    }

    public String getDescricao() {
      return descricao;
    }

    public double getPreco() {
      return preco;
    }

    public int getQuantidade() {
      return quantidade;
    }

    public Date getDataCadastro() {
      return dataCadastro;
    }
  }
}
