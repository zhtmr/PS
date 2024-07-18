package org.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_14501 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int[] T = new int[N + 1];
    int[] P = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      T[i] = scan.nextInt();
      P[i] = scan.nextInt();
    }
    int[] dp = new int[N + 2];
    for (int i = N; i > 0; i--) {
      if (i + T[i] - 1 <= N) {
        dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
      } else {
        dp[i] = dp[i + 1];
      }
      sb.append(dp[1]).append("\n");
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
