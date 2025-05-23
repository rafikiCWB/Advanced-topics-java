package com.desafio.exercism.nullability;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BadgeTest {

  Badge badge = new Badge();

  @Test
  void labelForEmployee() {
    Assertions.assertThat(badge.print(17, "Charlotte Hale", "Marketing"))
            .isEqualTo("[17] - Charlotte Hale - MARKETING");

  }

  @Test
  void labelForNewEmployee() {
    Assertions.assertThat(badge.print(null, "Harry Potter", "Magic"))
            .isEqualTo("Harry Potter - MAGIC");
  }

  @Test
//  @Tag("task:3")
//  @DisplayName("Printing a badge for the owner");
  void labelForOwner() {
    Assertions.assertThat(badge.print(1, "Rafael Grando", null))
            .isEqualTo("[1] - Rafael Grando - OWNER");
  }
}