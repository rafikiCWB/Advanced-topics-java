package com.desafio.arquivos;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppProduto extends ProdutoService {
    public static void main(String[] args) throws IOException {
        List<Product> p = new ArrayList<>();
        p.add(new Product("tv", new BigDecimal("990.00"), 1));
        p.add(new Product("celular", new BigDecimal("1990.00"), 1));
        p.add(new Product("pc", new BigDecimal("2990.00"), 1));


//        escreverLayoutDelimitado(p);
        escreverLayoutPosicional(p);

    }
}
