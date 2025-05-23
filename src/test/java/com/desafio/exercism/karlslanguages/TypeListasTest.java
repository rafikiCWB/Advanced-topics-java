package com.desafio.exercism.karlslanguages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeListasTest {

   TypeListas languageList;


  @BeforeEach
  void setUp() {
    languageList = new TypeListas();
  }

  @Test
  void removeLanguage() {
    languageList.addLanguage("Java");
    languageList.removeLanguage("Java");
    assertThat(languageList.isEmpty()).isTrue();
  }

  @Test
  @Tag("task:5")
  @DisplayName("The count method returns the number of languages in the list")
  public void countThree() {
    languageList.addLanguage("Java");
    languageList.addLanguage("Python");
    languageList.addLanguage("Ruby");
    assertThat(languageList.count()).isEqualTo(3);
  }

  @Test
  @Tag("task:5")
  @DisplayName("The count method returns 0 when the list is empty")
  public void countEmpty() {
    assertThat(languageList.count()).isEqualTo(0);
  }

//  @Test
//  public void dynamicLanguageCount() {
//    int numLanguages = (int) (Math.random() * 100); // Random number between 0-100
//    for (int i = 0; i < numLanguages; i++) {
//      languageList.addLanguage("Language" + i);
//    }
//    assertThat(languageList.count()).isEqualTo(numLanguages);
//  }

  @Test
  public void listaEmpolgante() {
    languageList.addLanguage("Java");
    languageList.addLanguage("Kotlin");
    assertThat(languageList.isExciting()).isTrue();
  }

  @Test
  public void firstLanguage() {
    languageList.addLanguage("Java");
    languageList.addLanguage("Kotlin");
    assertThat(languageList.firstLanguage()).isEqualTo("Java");
  }
  @Test
  @Tag("task:7")
  @DisplayName("The isExciting method returns false when the list contains neither Java nor Kotlin")
  public void boringLanguageList() {
    languageList.addLanguage("Python");
    languageList.addLanguage("Ruby");
    languageList.addLanguage("C++");
    assertThat(languageList.isExciting()).isFalse();
  }

  @Test
  public void containsLanguage() {
    languageList.addLanguage("Java");
    assertThat(languageList.containsLanguage("Java")).isTrue();
  }

}