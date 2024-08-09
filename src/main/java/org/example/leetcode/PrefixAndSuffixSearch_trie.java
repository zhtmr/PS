package org.example.leetcode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PrefixAndSuffixSearch_trie {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static TrieNode root;

  public static void main(String[] args) {
    input();
  }

  static class TrieNode {
    Map<Character, TrieNode> children;
    int index;

    public TrieNode() {
      children = new HashMap<>();
      index = -1;
    }
  }

  static void input() {

    String[] words = {"apple"};

    root = new TrieNode();
    int length = words.length;
    for (int i = 0; i < length; i++) {
      String word = words[i];
      int len = word.length();
      for (int j = 0; j <= len; j++) {
        String string = word.substring(j) + "{" + word;
        insert(string, i);
      }
    }


  }

  private static void insert(String word, int index) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      current = current.children.computeIfAbsent(ch, c -> new TrieNode());
      current.index = index;
    }
  }

  static int f(String pref, String suf) {
    String searchWord = pref + "{" + suf;
    TrieNode current = root;
    for (char ch : searchWord.toCharArray()) {
      current = current.children.get(ch);
      if (current == null) {
        return -1;
      }
    }
    return current.index;
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
