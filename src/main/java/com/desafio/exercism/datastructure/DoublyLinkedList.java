package com.desafio.exercism.datastructure;

class DoublyLinkedList<T> {
  private Element<T> head;

  void push(T value) {
    Element<T> newElement = new Element<>(value, null, null);
    if (head == null) {
      head = newElement;
    } else {
      Element<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newElement;
      newElement.prev = current;
    }
  }

  T pop() {
    if (head == null) {
      throw new IllegalStateException("List is empty");
    }

    Element<T> current = head;
    while (current.next != null) {
      current = current.next;
    }

    T value = current.value;

    if (current.prev != null) {
      current.prev.next = null;
    } else {
      head = null;
    }

    return value;
  }

  void unshift(T value) {
    Element<T> newElement = new Element<>(value, null, head);
    if (head != null) {
      head.prev = newElement;
    }
    head = newElement;
  }

  T shift() {
    if (head == null) {
      throw new IllegalStateException("List is empty");
    }

    T value = head.value;
    head = head.next;
    
      if (head != null) {
          head.prev = null;
      }
    
      return value;
  }

  private static final class Element<T> {
    private final T value;
    private Element<T> prev;
    private Element<T> next;

    Element(T value, Element<T> prev, Element<T> next) {
      throw new UnsupportedOperationException("Please implement the Element constructor.");
    }
  }
}
