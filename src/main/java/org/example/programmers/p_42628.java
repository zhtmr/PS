package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_42628 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    String[] operations2 =
        {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};


    for (String command : operations2) {
      if (command.contains("I")) {
        maxHeap.add(Integer.valueOf(command.split(" ")[1]));
        minHeap.add(Integer.valueOf(command.split(" ")[1]));
      } else if (command.equals("D 1")) {
        minHeap.remove(maxHeap.poll());
        System.out.println("minHeap = " + minHeap);
        System.out.println("maxHeap = " + maxHeap);
      } else {
        maxHeap.remove(minHeap.poll());
        System.out.println("minHeap = " + minHeap);
        System.out.println("maxHeap = " + maxHeap);
      }
    }


    int[] result = new int[2];
    result[0] = maxHeap.peek() == null ? 0 : maxHeap.peek();
    result[1] = minHeap.peek() == null ? 0 : minHeap.peek();
    System.out.println(Arrays.toString(result));
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
