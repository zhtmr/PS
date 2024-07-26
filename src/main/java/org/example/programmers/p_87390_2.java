package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_87390_2 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int n = scan.nextInt();
    long left = scan.nextInt();
    long right = scan.nextInt();

    // 굳이 배열을 만들고 거기에 값을 담을 필요 없이
    // 바로 result 배열에 인덱스 범위부터 값 세팅하면된다.
    int len = (int) (right - left + 1);
    int[] result = new int[len];

    for (int i = 0; i < len; i++) {
      long pos = left + i;
      int row = (int) (pos / n);
      int col = (int) (pos % n);
      result[i] = Math.max(row, col) + 1;
    }


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
