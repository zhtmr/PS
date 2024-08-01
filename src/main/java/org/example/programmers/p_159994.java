package org.example.programmers;

import java.io.*;
import java.util.*;

public class p_159994 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] card1 = {"i", "drink", "water"};
    String[] card11 = {"i", "water", "drink"};
    String[] card2 = {"want", "to"};
    String[] goal = {"i", "want", "to", "drink", "water"};


//    System.out.println("card1 = " + Arrays.toString(card1));
//    System.out.println("card11 = " + Arrays.toString(card11));
//    System.out.println("card2 = " + Arrays.toString(card2));
//    System.out.println("goal = " + Arrays.toString(goal));

    Queue<String> card1Queue = new ArrayDeque<>(List.of(card11));
    Queue<String> card2Queue = new ArrayDeque<>(List.of(card2));
    Queue<String> goalQ = new ArrayDeque<>(List.of(goal));
    System.out.println("card1Queue = " + card1Queue);
    System.out.println("card2Queue = " + card2Queue);
    System.out.println("goalQ = " + goalQ);

    System.out.println(check(card1Queue, card2Queue, goalQ));
  }

  private static String check(Queue<String> card1Queue, Queue<String> card2Queue,
      Queue<String> goalQ) {
    while (!goalQ.isEmpty()) {
      String peek = goalQ.peek();
      if (!card1Queue.isEmpty() && card1Queue.peek().equals(peek)) {
        card1Queue.poll();
        goalQ.poll();
      } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(peek)) {
        card2Queue.poll();
        goalQ.poll();
      } else {
        return "No";
      }
    }
    return "Yes";
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

}
