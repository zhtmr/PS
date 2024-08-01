package org.example.programmers;

import java.io.*;
import java.util.*;

public class p_42586_pair {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    //    input();
    solve();
  }

  static void solve() {
    int[] prog = {93, 30, 55};
    int[] prog1 = {95, 90, 99, 99, 80, 99};

    int[] speed = {1, 30, 5};
    int[] speed1 = {1, 1, 1, 1, 1, 1, 1};

    Deque<Integer> days = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();
    // 7, 3, 9
    for (int i = 0; i < prog.length; i++) {
      int v = (int) Math.ceil((100 - prog[i]) / (double) speed[i]);
      if (days.peek() != null && days.peek() < v) {
        list.add(days.size());
        days.clear();
      }
      days.offer(v);
    }
    list.add(days.size());
    int[] ans = list.stream().mapToInt(i -> i).toArray();
    System.out.println(list);
  }

  static void solve01() {
    int[] prog = {93, 30, 55};
    int[] prog1 = {95, 90, 99, 99, 80, 99};

    int[] speed = {1, 30, 5};
    int[] speed1 = {1, 1, 1, 1, 1, 1, 1};

    Map<Integer, Integer> map = new TreeMap<>();
    int max = 0;
    for (int i = 0; i < prog1.length; i++) {
      int per = 100 - prog1[i];
      int date;
      if (per % speed1[i] == 0)
        date = per / speed1[i];
      else
        date = per / speed1[i] + 1;

      if (max < date)
        max = date;
      map.put(max, map.getOrDefault(max, 0) + 1);
    }

    List<Integer> list = new ArrayList<>(map.values());
    int[] ans = list.stream().mapToInt(i -> i).toArray();
    System.out.println(ans);
  }

  static void input() {
    int[] prog1 = {93, 30, 55};
    int[] prog = {95, 90, 99, 99, 80, 99};

    int[] speed1 = {1, 30, 5};
    int[] speed = {1, 1, 1, 1, 1, 1, 1};

    ArrayList<Integer> days = new ArrayList<>();

    for (int i = 0; i < prog1.length; i++) {
      int v = (int) Math.ceil((100 - (double) prog1[i]) / (double) speed1[i]);
      days.add(v);
    }


    int count = 1;
    Integer prev = days.get(0);

    ArrayList<Integer> result = new ArrayList<>();
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


    int[] arr = new int[result.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = result.get(i);
    }
    System.out.println(Arrays.toString(arr));
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
