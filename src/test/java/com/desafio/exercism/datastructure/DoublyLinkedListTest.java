package com.desafio.exercism.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

  @Test
  void popGetsElementsFromTheList() {
    DoublyLinkedList<Integer> list =
            new DoublyLinkedList<>();

    list.push(7);
    Assertions.
            assertThat(list
                    .pop())
            .isEqualTo(7);
  }

  @Disabled("Remove to run test")
  @Test
  void pushAndPopRespectivelyAddsAndRemovesAtEndOfList() {

    DoublyLinkedList<Integer> list =
            new DoublyLinkedList<>();
    list.push(7);
    list.push(13);

    Assertions
            .assertThat(list
                    .pop())
            .isEqualTo(13);
    Assertions
            .assertThat(list
                    .pop())
            .isEqualTo(7);
  }
}