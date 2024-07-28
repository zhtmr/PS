package org.example.programmers;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p_42578 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[][] clothes = {
        {"yellow_hat", "headgear"},
        {"blue_sunglasses", "eyewear"},
        {"blue_sunglasses2", "eyewear"},
        {"green_turban", "headgear"},
        {"green_turban2", "headgear"},
    };

    String[][] clothes2 = {
        {"crow_mask", "face"},
        {"blue_sunglasses", "face"},
        {"smoky_makeup", "face"}
    };

    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < clothes.length; i++) {
      map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
    }

    int answer = 1;
    for (int count : map.values()) {
      answer *= count + 1;
    }


    System.out.println(answer - 1);


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
