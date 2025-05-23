package com.desafio.exercism.nullability;

import java.util.concurrent.atomic.AtomicReference;

public class Badge {

  public static void main(String[] args) {
    var badge = new Badge();
    String employee = badge.print(1, "Charlotte Hale", "Marketing");
    System.out.println(employee);
  }

  public String print(Integer id, String name, String department) {
    AtomicReference<StringBuilder> badge = new AtomicReference<>(new StringBuilder());
    if (id != null) {
      badge.get().append("[").append(id).append("]").append(" - ");
    }
    badge.get().append(name);
    badge.get().append(" - ");
    if (department == null) {
      badge.get().append("OWNER");
    } else {
      badge.get().append(department.toUpperCase());
    }
    return badge.toString();
  }
}


/**
 * StringBuilder badge = new StringBuilder();
 * if (id != null) {
 * badge.append("[").append(id).append("]").append(" - ");
 * }
 * badge.append(name);
 * badge.append(" - ");
 * if (department == null) {
 * badge.append("OWNER");
 * } else {
 * badge.append(department.toUpperCase());
 * }
 * return badge.toString();
 */