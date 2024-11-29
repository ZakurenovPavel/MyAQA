package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello, World!");
    Car ferrari = new Car();

    int[] integers = new int[5];
    integers[0] = 1;
    integers[1] = 2;
    integers[2] = 3;
    integers[3] = 4;
    integers[4] = 5;

    int[] numbers = {1, 2, 3, 4, 5};

    List<String> names = new ArrayList<>();
    names.add("Pavel");
    names.add("Ivan");
    names.add("Sergey");

    checkIntegers(integers[2]);
    checknames("Leila");

    int count = 10;
    while (count >= 0) {
      System.out.println("До запуска:" + count);
      count--;
    }

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 3) {break;}
      System.out.println(numbers[i]);
    }

    for (String s : names) {
      System.out.println(s);
    }

  }

  public static void checkIntegers(int test) {
    if (test == 2) {
      System.out.println("it's correct number");
    } else {
      System.out.println("it's wrong number");
    }
  }

  public static void checknames(String name) {
    switch (name) {
      case "Pavel" -> {
        System.out.println("it's pavel");
        break;
      }
      case "Ivan" -> {
        System.out.println("it's ivan");
        break;
      }
      default -> System.out.println("it's wrong name");
    }
  }
}