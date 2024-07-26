package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_12915 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] arr = {"sun", "bed", "car"};
    String[] arr2 = {"abce", "abcd", "cdx"};

    int n = 1;

//    for (int i = 0; i < arr.length; i++) {
//      for (int j = i + 1; j < arr.length; j++) {
//        char c = arr[i].charAt(n);
//        char c1 = arr[j].charAt(n);
//        if (c > c1) {
//          String tmp = arr[i];
//          arr[i] = arr[j];
//          arr[j] = tmp;
//        } else if (c == c1) {
//          if (arr[i].compareTo(arr[j]) > 0) {
//            String tmp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = tmp;
//          }
//        }
//      }
//    }


    Arrays.sort(arr, (o1, o2) -> {
      if (o1.charAt(n) == o2.charAt(n)) {
        return o1.compareTo(o2);
      } else {
        return o1.charAt(n) - o2.charAt(n);
      }
    });


    System.out.println(Arrays.toString(arr));
//    System.out.println(Arrays.toString(arr2));
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
