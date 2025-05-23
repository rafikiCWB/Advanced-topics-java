package com.desafio.advancedjava.stream;

import java.util.Comparator;

class OrdenarProdutoPreco implements Comparator<Produto> {

  @Override
  public int compare(Produto p1, Produto p2) {
    return p1.getPreco().compareTo(p2.getPreco());
  }

}