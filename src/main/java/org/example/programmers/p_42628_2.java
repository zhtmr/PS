package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class p_42628_2 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    String[] operations2 =
        {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
    TreeMap<Integer, Integer> map = new TreeMap<>();

    for (String command : operations) {
      if (command.contains("I")) {
        String num = command.split(" ")[1];
        map.put(Integer.valueOf(num), map.getOrDefault(Integer.valueOf(num), 0) + 1);
      } else if (command.equals("D 1")) {
        if (map.isEmpty()) {
          continue;
        }
        Integer max = map.lastKey();
        if (map.get(max) == 1) {
          map.remove(max);
        } else {
          map.put(max, map.get(max) - 1);
        }
      } else {
        if (map.isEmpty()) {
          continue;
        }
        Integer min = map.firstKey();
        if (map.get(min) == 1) {
          map.remove(min);
        } else {
          map.put(min, map.get(min) - 1);
        }
      }
    }


    int[] result = new int[2];
    if (map.isEmpty()) {
      result[0] = 0;
      result[1] = 0;
    } else {
      result[0] = map.lastKey();
      result[1] = map.firstKey();
    }
    System.out.println(Arrays.toString(result));
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
