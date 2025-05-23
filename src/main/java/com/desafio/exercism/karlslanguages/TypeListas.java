package com.desafio.exercism.karlslanguages;

import java.util.ArrayList;
import java.util.List;

public class TypeListas {
  @Override
  public String toString() {
    return "TypeListas{" +
            "languages=" + languages +
            '}';
  }

  public final List<String> languages = new ArrayList<>();

  public static void main(String[] args) {
    var t = new TypeListas();
    t.addLanguage("Java");
    t.addLanguage("Java");
    t.addLanguage("Java");
    t.addLanguage("Java");
    t.addLanguage("Java");
    t.addLanguage("Java");
    t.addLanguage("Java");
    t.addLanguage("Java");

    for (String language : t.languages) {
      System.out.println(language);
    }
  }

  public boolean isEmpty() {
    return languages.isEmpty();
  }

  public void addLanguage(String language) {
    languages.add(language);

  }

  public void removeLanguage(String language) {
//    languages.removeAll(List.of(language));
    languages.remove(language);
  }

  public String firstLanguage() {
    return languages.getFirst();
  }

  public int count() {
//    return Math.toIntExact(languages.stream().count());
    return languages.size();
  }

  public boolean containsLanguage(String language) {
    return languages.contains(language);
  }

  public boolean isExciting() {
    // mesma coisa que: return languages.contains("Java) || languages.contains("Kotlin);
    return languages.stream()
            .anyMatch(lang -> lang.equals("Java") || lang.equals("Kotlin"));
  }
}
