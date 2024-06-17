package org.example.codetree;

import java.io.*;
import java.util.StringTokenizer;

public class DiagonalNumbering {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {

    int n = scan.nextInt();
    int m = scan.nextInt();
    int[][] arr = new int[n][m];
    int count = 0;
    int nth = 0;
    int sum = 0;
    int add = 0;

    while (count != n * m) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (i + j == nth) {
            int e = sum + ++add;
            arr[i][j] = e;
            count++;
          }
        }
      }
      nth++;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(arr[i][j] +" ");
      }
      System.out.println();
    }
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
