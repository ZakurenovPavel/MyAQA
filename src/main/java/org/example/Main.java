package org.example;

import java.util.ArrayList;

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

    ArrayList<String> list = new ArrayList<String>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");
    list.add("G");
    list.add("H");
    list.add("I");
    list.add("J");
    for(String element : list) {
      System.out.println(element);
    }
  }
}