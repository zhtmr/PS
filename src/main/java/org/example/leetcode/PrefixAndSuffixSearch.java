package org.example.leetcode;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PrefixAndSuffixSearch {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static HashMap<String, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    input();
  }

  static void input() {


    String[] words = {"apple"};

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int length = word.length();
      for (int j = 1; j <= length; j++) {
        for (int k = 1; k <= length; k++) {
          String key = word.substring(0, j) + "{" + word.substring(length - k);
          map.put(key, i);
        }
      }
    }

    System.out.println(map);

  }

  static int f(String pre, String suf) {
    String s = pre + "{" + suf;
    return map.getOrDefault(s, -1);
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
