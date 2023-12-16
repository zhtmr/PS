package org.example.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10988 {

  static FastReader scan = new FastReader();
  //정답은 sb에 append 를 사용하여 출력
  //만약 개행까지 출력하고 싶으면 append('\n')을 추가
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String s = scan.next();
    String[] reverse = new String[s.length()];

    int i = 0;
    int j = s.length() - 1;

    int T = j - i;
    for (int r = 0; r <= T; r++, i++, j--) {
      reverse[r] = String.valueOf(s.charAt(j));
    }

    if (check(reverse, s) == s.length()) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }

  }

  private static int check(String[] reverse, String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == reverse[i].charAt(0)) {
        cnt++;
      }
    }
    return cnt;
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
