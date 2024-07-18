package org.example.boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10815 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scan.nextInt();
    }
    Arrays.sort(arr);
    int M = scan.nextInt();
    for (int i = 0; i < M; i++) {
      int isExist = Arrays.binarySearch(arr, scan.nextInt());
      sb.append(isExist >= 0 ? 1 : 0).append(" ");
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
