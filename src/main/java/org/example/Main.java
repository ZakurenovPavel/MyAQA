package org.example;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    int[] arr = new int[7];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
      if (arr[i] == 5) {
        break;
      }
    }

    List<String> list = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
    for(String element : list) {
      System.out.println(element);
    }
  }
}