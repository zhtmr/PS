package org.example.programmers;

import java.util.HashMap;
import java.util.Map;

public class p_148653_3 {
  private final Map<Integer, Integer> memo = new HashMap<>();

  public int solution(int storey) {
    if (storey <= 5) {
      return storey;
    } else if (storey < 10) {
      return 11 - storey;
    }

    if (memo.containsKey(storey)) {
      return memo.get(storey);
    }

    int lastNum = storey % 10;
    int down = solution(storey / 10) + lastNum;
    int up = solution(storey / 10 + 1) + (10 - lastNum);

    int answer = Math.min(down, up);
    memo.put(storey, answer);

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new p_148653_3().solution(16));
    System.out.println(new p_148653_3().solution(2554));
    System.out.println(new p_148653_3().solution(15));
  }
}
