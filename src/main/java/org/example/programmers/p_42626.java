package org.example.programmers;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_42626 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int[] scoville = {9, 1, 2, 3, 10, 12};
    int K = 7;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int j : scoville) {
      minHeap.add(j);
    }

    Integer count = getInteger(minHeap, K);
    System.out.println(count);
  }

  private static Integer getInteger(PriorityQueue<Integer> minHeap, int K) {
    int count = 0;

    while (minHeap.peek() < K) {
      if (minHeap.size() <= 1) {
        count = -1;
        break;
      }
      Integer firstMin = minHeap.poll();
      Integer secondMin = minHeap.poll();
      int newScoville = firstMin + (secondMin * 2);
      minHeap.add(newScoville);
      count++;

    }
    return count;
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
