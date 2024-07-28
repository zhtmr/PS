package org.example.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1654 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int K = scan.nextInt();
    int N = scan.nextInt();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      list.add(scan.nextInt());
    }
    int sum = 0;
    for (int i : list) {
      sum += i;
    }

    System.out.println(sum / N);
    int sum2 = 0;
    for (int i = 0; i < list.size(); i++) {
      sum2 += list.get(i) / 231;
    }
    System.out.println(sum2);
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
