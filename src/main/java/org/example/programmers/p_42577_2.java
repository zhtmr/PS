package org.example.programmers;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p_42577_2 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] arr = {"119", "97674223", "1195524421"};
    String[] arr1 = {"123","456","789"};
    String[] arr2 = {"12","123","1235","567","88"};
    String[] arr3 = {"123", "3123"};
    String[] arr4 = {"123", "12"};

//    System.out.println(checkPrefix(arr));
//    System.out.println(checkPrefix(arr1));
//    System.out.println(checkPrefix(arr2));
//    System.out.println(checkPrefix(arr3));
    System.out.println(checkPrefix(arr4));
  }

  static boolean checkPrefix(String[] arr) {
    HashSet<String> set = new HashSet<>();
    for (String s : arr) {
      for (int j = 1; j <= s.length(); j++) {
        String prefix = s.substring(0, j);
        if (set.contains(prefix)) {
          return false;
        }
      }
      set.add(s);
    }
    return true;
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
