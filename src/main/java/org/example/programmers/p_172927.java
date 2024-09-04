package org.example.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class p_172927 {
  static class Pick implements Comparable<Pick> {
    int diamondPick;
    int ironPick;
    int stonePick;

    public Pick(int diamondPick, int ironPick, int stonePick) {
      this.diamondPick = diamondPick;
      this.ironPick = ironPick;
      this.stonePick = stonePick;
    }

    @Override
    public int compareTo(Pick o) {
      return (o.diamondPick + o.ironPick + o.stonePick) - (this.diamondPick + this.ironPick + this.stonePick);
    }

    @Override
    public String toString() {
      return "Pick{" + "diamondPick=" + diamondPick + ", ironPick=" + ironPick + ", stonePick=" + stonePick + '}';
    }
  }

  public int solution(int[] picks, String[] minerals) {
    int answer = 0;
    int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    int length = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);
    int q = length / 5;
    int r = length % 5;
    ArrayList<Pick> sum = new ArrayList<>();

    for (int i = 0; i < q; i++) {
      int diamondPick = 0, ironPick = 0, stonePick = 0;
      for (int j = 0; j < 5; j++) {
        if (minerals[i * 5 + j].equals("diamond")) {
          diamondPick += fatigue[0][0];
          ironPick += fatigue[1][0];
          stonePick += fatigue[2][0];
        } else if (minerals[i * 5 + j].equals("iron")) {
          diamondPick += fatigue[0][1];
          ironPick += fatigue[1][1];
          stonePick += fatigue[2][1];
        } else {
          diamondPick += fatigue[0][2];
          ironPick += fatigue[1][2];
          stonePick += fatigue[2][2];
        }
      }
      sum.add(new Pick(diamondPick, ironPick, stonePick));
    }

    if (r != 0) {
      int diamondPick = 0, ironPick = 0, stonePick = 0;
      for (int i = 0; i < r; i++) {
        if (minerals[q * 5 + i].equals("diamond")) {
          diamondPick += fatigue[0][0];
          ironPick += fatigue[1][0];
          stonePick += fatigue[2][0];
        } else if (minerals[q * 5 + i].equals("iron")) {
          diamondPick += fatigue[0][1];
          ironPick += fatigue[1][1];
          stonePick += fatigue[2][1];
        } else {
          diamondPick += fatigue[0][2];
          ironPick += fatigue[1][2];
          stonePick += fatigue[2][2];
        }
      }
      sum.add(new Pick(diamondPick, ironPick, stonePick));
    }

    Collections.sort(sum);

    System.out.println("sum = " + sum);

    for (Pick p : sum) {
      if (picks[0] > 0) {
        answer += p.diamondPick;
        picks[0]--;
      } else if (picks[1] > 0) {
        answer += p.ironPick;
        picks[1]--;
      } else if (picks[2] > 0) {
        answer += p.stonePick;
        picks[2]--;
      } else {
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
//    new p_172927().solution(new int[] {1, 3, 2},
//        new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
//
//    new p_172927().solution(new int[] {0, 1, 1},
//        new String[] {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron",
//            "iron", "iron", "diamond"});

    int solution = new p_172927().solution(new int[] {1, 0, 1},
        new String[] {"stone", "stone", "stone", "stone", "stone", "iron", "iron", "iron", "iron",
            "iron", "diamond", "diamond"});
    System.out.println("solution = " + solution);
  }
}
