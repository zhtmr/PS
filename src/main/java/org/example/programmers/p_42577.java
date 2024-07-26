package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_42577 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] arr = {"119", "97674223", "1195524421"};
    String[] arr1 = {"123","456","789"};
    String[] arr2 = {"12","123","1235","567","88"};
    String[] arr4 = {"123", "12"};

    Arrays.sort(arr4);
    boolean flag = true;
    for (int i = 0; i < arr4.length - 1; i++) {
      if (arr4[i + 1].startsWith(arr4[i])) {
        flag = false;
        break;
      }
    }
    System.out.println(flag);
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
