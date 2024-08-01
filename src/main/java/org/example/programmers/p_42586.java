package org.example.programmers;

import java.io.*;
import java.util.*;

public class p_42586 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int[] prog1 = {93, 30, 55};
    int[] prog = {95, 90, 99, 99, 80, 99};

    int[] speed1 = {1, 30, 5};
    int[] speed = {1, 1, 1, 1, 1, 1, 1};


    List<Integer> days = new ArrayList<>();
    for (int i = 0; i < prog.length; i++) {
      int v = (int) Math.ceil((100 - (double) prog[i]) / (double) speed[i]);
      days.add(v);
    }

    System.out.println("days = " + days);

    ArrayList<Integer> result = new ArrayList<>();
    int count = 1;
    int prev = days.get(0);

    for (int i = 1; i < days.size(); i++) {
      if (prev >= days.get(i)) {
        count++;
      } else {
        result.add(count);
        count = 1;
        prev = days.get(i);
      }
    }
    result.add(count);

    System.out.println("result = " + result);



    int[] answer = new int[result.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = result.get(i);
    }

    System.out.println(Arrays.toString(answer));
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
