package org.example.programmers;

import java.util.Arrays;

public class p_42885 {

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    int left = 0;
    int right = people.length - 1;

    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        left++;
      }
      answer++;
      right--;
    }


    return answer;
  }

  public static void main(String[] args) {
    int[] people = {70, 50, 80, 50};
    int limit = 100;
    System.out.println(new p_42885().solution(people, limit));

  }
}
