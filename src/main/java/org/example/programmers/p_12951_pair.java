package org.example.programmers;

import java.util.Arrays;

public class p_12951_pair {

  public String solution(String s) {
    StringBuilder answer = new StringBuilder();
    String[] arr = s.toLowerCase().split("");
    System.out.println("arr = " + Arrays.toString(arr));
    boolean flag = true;

    for (String str : arr) {
      answer.append(flag ? str.toUpperCase() : str);
      flag = str.equals(" ");
    }
    return answer.toString();
  }


  public static void main(String[] args) {
    p_12951_pair sol = new p_12951_pair();
    String s = "3people unFollowed me";
    String s2 = "  3people unFollowed me  ";
    System.out.println(sol.solution(s2));

  }

}


