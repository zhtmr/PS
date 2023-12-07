package org.example.boj;

import java.util.Scanner;

public class Boj_2753 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();

    if (input % 4 == 0 && input % 100 != 0 || input % 400 == 0) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

}
