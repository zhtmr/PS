package org.example.programmers;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_42628_3 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    PriorityQueue<Node> minHeap = new PriorityQueue<>();
    PriorityQueue<Node> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    String[] operations2 = {"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"};
    String[] operations3 =
        {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
    boolean[] visited = new boolean[operations2.length];



    for (int i = 0, len = operations2.length; i < len; i++) {
      String command = operations2[i];
      if (command.contains("I")) {
        int num = Integer.parseInt(command.split(" ")[1]);
        Node node = new Node(num, i);
        maxHeap.add(node);
        minHeap.add(node);
        visited[i] = true;
      } else if (command.equals("D 1")) {
        while (!maxHeap.isEmpty() && !visited[maxHeap.peek().index]) {
          maxHeap.poll();
        }
        if (!maxHeap.isEmpty()) {
          visited[maxHeap.poll().index] = false;
        }
      } else {
        while (!minHeap.isEmpty() && !visited[minHeap.peek().index]) {
          minHeap.poll();
        }
        if (!minHeap.isEmpty()) {
          visited[minHeap.poll().index] = false;
        }
      }
    }

    while (!minHeap.isEmpty() && !visited[minHeap.peek().index]) {
      minHeap.poll();
    }
    while (!maxHeap.isEmpty() && !visited[maxHeap.peek().index]) {
      maxHeap.poll();
    }

    int[] result = new int[2];
    if (minHeap.isEmpty() || maxHeap.isEmpty()) {
      result[0] = 0;
      result[1] = 0;
    } else {
      result[0] = maxHeap.peek().value;
      result[1] = minHeap.peek().value;
    }


    System.out.println(Arrays.toString(result));
  }

  static class Node implements Comparable<Node> {
    int value;
    int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.value, o.value);
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
