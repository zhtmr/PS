package org.example.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p_42883 {
  static class Solution {
    public String solution(String number, int k) {
      StringBuilder sb = new StringBuilder();
      ArrayDeque<Character> stack = new ArrayDeque<>();

      for (int i = 0; i < number.length(); i++) {
        char c = number.charAt(i);
        while (!stack.isEmpty() && stack.peek() < c && k > 0) {
          stack.pop();
          k--;
        }
        stack.push(c);
      }

      System.out.println("stack = " + stack);
      for (int i = 0; i < k; i++) {
        stack.pop();
      }

      for (char c : stack) {
        sb.append(c);
      }

      System.out.println("sb = " + sb.reverse());
      return sb.reverse().toString();
    }

  }


  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String number3 = "1924";
    String number5 = "1231234";
    String number4 = "4177252841";
    String number = "999";
    int k3 = 2;
    int k5 = 3;
    int k4 = 4;
    int k = 1;
    new Solution().solution(number, k);
  }
}
