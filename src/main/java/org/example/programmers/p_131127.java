package org.example.programmers;

import java.util.HashMap;

public class p_131127 {
  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      map.put(want[i], number[i]);
    }

    System.out.println(map);

    HashMap<String, Integer> discountMap;
    for (int i = 0; i <= discount.length - 10; i++) {
      discountMap = new HashMap<>();
      for (int j = i; j < i + 10; j++) {
        discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
      }
      if (map.equals(discountMap)) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    new p_131127().solution(new String[] {"banana", "apple", "rice", "pork", "pot"},
        new int[] {3, 2, 2, 2, 1},
        new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
            "pork", "rice", "pot", "banana", "apple", "banana"});

    new p_131127().solution(new String[] {"apple"}, new int[] {10},
        new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana",
            "banana", "banana", "banana"});
  }
}
