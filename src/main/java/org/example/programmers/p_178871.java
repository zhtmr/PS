package org.example.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class p_178871 {
  public String[] solution(String[] players, String[] callings) {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      String player = players[i];
      map.put(player, i);
    }

//    List<String> list = Arrays.asList(players);
    for (String call : callings) {
      Integer index = map.get(call);
      if (index == 0) continue;

      String prev = players[index - 1];
      players[index - 1] = call;
      players[index] = prev;

      map.put(call, index - 1);
      map.put(prev, index);
//      int index = list.indexOf(call);
//      if (index == 0) continue;
//      Collections.swap(list, index, index - 1);
      System.out.println("index = " + index);
    }

    return players;
  }

  public static void main(String[] args) {
    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};
    System.out.println(Arrays.toString(new p_178871().solution(players, callings)));

  }
}

