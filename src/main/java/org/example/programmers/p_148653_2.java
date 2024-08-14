package org.example.programmers;

public class p_148653_2 {
  public int solution(int storey) {
    int[] dp = new int[storey + 1];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 4;
    dp[5] = 5;
    dp[6] = 5;
    dp[7] = 4;
    dp[8] = 3;
    dp[9] = 2;
    for (int i = 10; i <= storey; i++) {
      int lastNum = i % 10;

      dp[i] = Math.min(dp[i / 10 + 1] + (10 - lastNum), dp[i / 10] + lastNum);
    }
    return dp[storey];
  }

  public static void main(String[] args) {
    new p_148653_2().solution(16);
    new p_148653_2().solution(2554);
    new p_148653_2().solution(15);
  }
}
