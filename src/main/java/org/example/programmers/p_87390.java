package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_87390 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int n = scan.nextInt();
    long left = scan.nextInt();
    long right = scan.nextInt();

    // 시간초과됨
    int[][] arr = new int[n][n];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i - 1][j - 1] = Math.max(j, i);
      }
    }

    System.out.println(Arrays.deepToString(arr));
    int[] tmp = new int[arr.length * arr[0].length];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        tmp[arr[i].length * i + j] = arr[i][j];
      }
    }

    int[] result = Arrays.copyOfRange(tmp, (int) left, (int) right + 1);


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
