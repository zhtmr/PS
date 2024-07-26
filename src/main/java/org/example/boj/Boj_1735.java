package org.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1735 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int Ac = scan.nextInt();
    int Ap = scan.nextInt();
    int Bc = scan.nextInt();
    int Bp = scan.nextInt();

    int gcd = gcd(Ap, Bp);
    int lcm = Ap * Bp / gcd;
    int An = Ac * (lcm / Ap);
    int Bn = Bc * (lcm / Bp);
    int sumN = An + Bn;

    simplify(sumN, lcm);
  }

  private static void simplify(int a, int b) {
    int gcd = gcd(a, b);
    System.out.printf("%d %d", a / gcd, b / gcd);
  }

  private static int gcd(int ap, int bp) {
    if (bp == 0) {
      return ap;
    }
    return gcd(bp, ap % bp);
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
