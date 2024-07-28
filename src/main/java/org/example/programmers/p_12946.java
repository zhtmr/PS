package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_12946 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int index = 0;
  static int[][] arr;

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    arr = new int[(int) (Math.pow(2, N) - 1)][2];

    hanoi(N, 1, 3, 2);
    System.out.println(Arrays.deepToString(arr));

  }

  static void hanoi(int n, int start, int end, int tmp) {
    if (n == 1) {
      record(start, end);
      return;
    }
    hanoi(n - 1, start, tmp, end);
    record(start, end);
    hanoi(n - 1, tmp, end, start);
  }

  private static void record(int start, int end) {
    arr[index][0] = start;
    arr[index][1] = end;
    index++;
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
