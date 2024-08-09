package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_84512_2 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static String[] alphabet = {"A", "E", "I", "O", "U"};
  static String[] all =
        new String[(int) (5 + Math.pow(5, 2) + Math.pow(5, 3) + Math.pow(5, 4) + Math.pow(5, 5))];
  static int index = 0;

  public static void main(String[] args) {
    input();
  }

  static void input() {



    for (int i = 1; i <= 5; i++) {
      dfs("", i,0);
    }

    System.out.println("all = " + Arrays.toString(all));

    String target = "EIO";
    Arrays.sort(all);
//    for (int i = 0; i < all.length; i++) {
//      if (all[i].equals(target)) {
//        System.out.println(i + 1);
//        break;
//      }
//    }
    System.out.println(Arrays.binarySearch(all, target) + 1);

  }

  static void dfs(String word, int length, int depth) {
    if (depth == length) {
      all[index++] = word;
      return;
    }
    for (String a : alphabet) {
      dfs(word + a, length, depth + 1);
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
