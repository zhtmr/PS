package org.example.leetcode;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RelativeRanks {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int[] score = {5, 4, 3, 2, 1};
    int[] score3 = {10, 3, 8, 9, 4};
    int[] score2 = {123123,11921,1,0,123};
                  // 1, 5, 3, 2, 4

    int max = findMax(score2);

    int[] scoreIdx = new int[max + 1];
    for (int i = 0; i < score2.length; i++) {
      scoreIdx[score2[i]] = i + 1;
    }

    String[] MEDAL = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    String[] rank = new String[score2.length];
    int place = 1;

    for (int i = max; i >= 0; i--) {
      if (scoreIdx[i] != 0) {
        int originalIdx = scoreIdx[i] - 1;
        if (place < 4) {
          rank[originalIdx] = MEDAL[place - 1];
        } else {
          rank[originalIdx] = String.valueOf(place);
        }
        place++;
      }
    }

//    System.out.println("scoreIdx = " + Arrays.toString(scoreIdx));
    System.out.println("rank = " + Arrays.toString(rank));



  }

  static int findMax(int[] score) {
    int max = 0;
    for (int j : score) {
      if (j > max) {
        max = j;
      }
    }
    return max;
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
