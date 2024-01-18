package org.example.boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int n = scan.nextInt();
    int[] arr = new int[n];

    Arrays.setAll(arr, i -> i + 1);

    for (int i = 0; i < arr.length; i++) {
      String s = String.valueOf(arr[i]);
      for (int j = 0; j < s.length(); j++) {
        if ((arr[i] % 3 == 0) || s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
          arr[i] = 0;
          break;
        }
      }
    }

    for (int k : arr) {
      System.out.print(k + " ");
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
