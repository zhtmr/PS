package org.example.boj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_24511 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    int N = scan.nextInt();
    int[] flag = new int[N];

    for (int i = 0; i < N; i++) {
      flag[i] = scan.nextInt();
    }

    for (int i = 0; i < N; i++) {
      int e = scan.nextInt();
      if (flag[i] == 0) {
        queue.offerFirst(e);
      }
    }


    int M = scan.nextInt();
    for (int i = 0; i < M; i++) {
      queue.offer(scan.nextInt());
      sb.append(queue.poll()).append(" ");
    }

    System.out.println(sb);

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
