package org.example.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class p_160586 {
  public int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];
    HashMap<Character, Integer> map = new HashMap<>();
    for (String s : keymap) {
      char[] charArray = s.toCharArray();
      for (int j = 0; j < charArray.length; j++) {
        char c = charArray[j];
        if (map.get(c) == null || map.get(c) > j) {
          map.put(c, j + 1);
        }
      }
    }

    for (int i = 0; i < targets.length; i++) {
      char[] charArray = targets[i].toCharArray();
      for (int j = 0; j < charArray.length; j++) {
        char c = charArray[j];
        if (map.containsKey(c)) {
          answer[i] += map.get(c);
        } else {
          answer[i] = -1;
          break;
        }
      }
    }
    System.out.println("map = " + map);
    System.out.println("answer = " + Arrays.toString(answer));
    return answer;
  }

  public static void main(String[] args) {
    new p_160586().solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD", "AABB"});
    new p_160586().solution(new String[] {"AA"}, new String[] {"B"});
    new p_160586().solution(new String[] {"AGZ", "BSSS"}, new String[] {"ASA","BGZ"});
    new p_160586().solution(new String[] {"AB", "AAB"}, new String[] {"B"});

  }
}
