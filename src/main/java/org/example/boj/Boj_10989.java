package org.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_10989 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    input();
  }

  static void input() throws IOException {
    int N = scan.nextInt();
    int[] cnt = new int[10001];
    for (int i = 0; i < N; i++) {
      cnt[scan.nextInt()]++;
    }
    for (int i = 1; i <= 10000; i++) {
      if (cnt[i] > 0) {
        for (int j = 0; j < cnt[i]; j++) {
          sb.append(i).append('\n');
        }
      }
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
