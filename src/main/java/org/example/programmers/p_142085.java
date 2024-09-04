package org.example.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p_142085 {
  public int solution(int n, int k, int[] enemy) {
    int answer = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < enemy.length; i++) {
      maxHeap.add(enemy[i]);
      n -= enemy[i];

      if (n < 0) {
        if (k > 0) {
          n += maxHeap.poll();
          k--;
        } else {
          break;
        }
      }
      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    new p_142085().solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1});

  }
}
