package org.example.programmers;

public class p_43165 {
  static int answer = 0;
  public int solution(int[] numbers, int target) {
    answer = 0;
    dfs(numbers, target, 0, 0);

    return answer;
  }

  private void dfs(int[] numbers, int target, int index, int sum) {
    if (index == numbers.length) {
      if (sum == target) {
        answer++;
      }
      return;
    }
    dfs(numbers, target, index + 1, sum + numbers[index]);
    dfs(numbers, target, index + 1, sum - numbers[index]);
  }

  public static void main(String[] args) {
    int solution = new p_43165().solution(new int[] {1, 1, 1, 1, 1}, 3);
    System.out.println("solution = " + solution);

    int solution1 = new p_43165().solution(new int[] {4, 1, 2, 1}, 4);
    System.out.println("solution1 = " + solution1);

  }
}
