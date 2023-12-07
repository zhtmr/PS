package org.example.boj;

import java.util.Scanner;

public class Boj_1330 {

  public static void main(String[] args) {
    String[] arr = {">", "<", "=="};

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    if (a > b) {
      System.out.println(">");
    } else if (a < b) {
      System.out.println("<");
    } else {
      System.out.println("==");
    }

    scanner.close();
  }
}
