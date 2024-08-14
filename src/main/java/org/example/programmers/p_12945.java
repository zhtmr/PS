package org.example.programmers;

public class p_12945 {
  public int solution(int n) {
    int answer = 0;
    int MOD = 1234567;

    int[] dp = new int[1000001];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }

    answer = dp[n] % MOD;
    return answer;
  }

  public static void main(String[] args) {
    int result = new p_12945().solution(3);
    System.out.println(result);
    int result2 = new p_12945().solution(5);
    System.out.println(result2);
  }
}
