package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_84512 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] alphabet = {"A", "E", "I", "O", "U"};

    String[] all =
        new String[(int) (5 + Math.pow(5, 2) + Math.pow(5, 3) + Math.pow(5, 4) + Math.pow(5, 5))];

    int index = 0;

    for (int i = 0; i < 5; i++) {
      all[index++] = alphabet[i];
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        all[index++] = alphabet[i] + alphabet[j];
      }
    }

//    System.out.println("all = " + Arrays.toString(all));

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          all[index++] = alphabet[i] + alphabet[j] + alphabet[k];
        }
      }
    }

//    System.out.println("all = " + Arrays.toString(all));

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          for (int l = 0; l < 5; l++) {
            all[index++] = alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l];
          }
        }
      }
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          for (int l = 0; l < 5; l++) {
            for (int m = 0; m < 5; m++) {
              all[index++] = alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m];
            }
          }
        }
      }
    }

    String target = "EIO";

    Arrays.sort(all);
    for (int i = 0; i < all.length; i++) {
      if (all[i].equals(target)) {
        System.out.println(i + 1);
        break;
      }
    }

//    System.out.println("all = " + Arrays.toString(all));

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
