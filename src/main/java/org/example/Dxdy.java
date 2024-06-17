package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Dxdy {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int x = 0 , y = 0, dirIndex = 0;
    //                       위 왼쪽 아래 오른
    int[] offsetX = new int[] {0, -1, 0, 1};
    int[] offsetY = new int[] {1, 0, -1, 0};

    String s = scan.next();
    int length = s.length();

    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      if (c == 'L') {
//        dirIndex += 1;
//        if (dirIndex > 3) {
//          dirIndex = 0;
//        }
        dirIndex = (dirIndex + 1) % 4;
      } else if (c == 'R') {
//        dirIndex -= 1;
//        if (dirIndex < 0) {
//          dirIndex = 3;
//        }
        dirIndex = (dirIndex - 1 + 4) % 4;
      } else {
        x = x + offsetX[dirIndex];
        y = y + offsetY[dirIndex];
      }
    }
    System.out.printf("%d %d", x, y);

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
