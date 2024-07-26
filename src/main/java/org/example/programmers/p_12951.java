package org.example.programmers;

import java.io.*;
import java.util.StringTokenizer;

public class p_12951 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String s = scan.nextLine().toLowerCase();
    String[] split = s.split(" ", -1);
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < split.length; i++) {
      String string = split[i];
      if (!string.isEmpty()) {
        String front = string.substring(0, 1).toUpperCase();
        result.append(front);
        result.append(string.substring(1));
      }
      result.append(i < split.length - 1 ? " " : "");
    }
    System.out.println(result);
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

