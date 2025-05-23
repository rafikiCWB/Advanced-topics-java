package com.desafio.advancedjava.stringjoiner;

import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * The StringJoinerExemplo class demonstrates the functionality and features of
 * the StringJoiner class in Java, which is used to join a sequence of strings
 * with a specified delimiter, prefix, and suffix.
 * <p>
 * This class showcases how to efficiently build and format strings with custom
 * delimiters, making it useful for scenarios such as generating CSV lines,
 * creating formatted outputs, and combining strings in a structured manner.
 * <p>
 * It highlights the ability to define prefix and suffix strings, as well as customizing
 * separators between the joined elements.
 */
public class StringJoinerExemplo {
  public static void main(String[] args) {
    String nomes = " Rafael, Pedro, Maria, Ana, Paulo";

    StringTokenizer st = new StringTokenizer(nomes, ",");

    while (st.hasMoreElements()) {
      System.out.println(st.nextToken());
    }

    StringJoiner sj = new StringJoiner(", ");
    sj.add("Rafa");
    sj.add("Polly");
    sj.add("Jacky");
    sj.add("Grando");

    System.out.println(sj);
   }
}




