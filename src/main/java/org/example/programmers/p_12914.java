package org.example.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_12914 {

  public long solution(int n) {
    long answer = 0;
    int[] dp = new int[2001];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for (int i = 4; i < dp.length; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
    }
    answer = dp[n];

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int solution = new p_12945().solution(Integer.parseInt(br.readLine()));
    System.out.println(solution);
    // 3
    // [2,1]
    // [1,2]
    // [1,1,1]
// 1이 두개, 2가 한개

    // 4
    // [2, 1, 1]
    // [1, 2, 1]
    // [1, 1, 1, 1]
    // [1, 1, 2]
    // [2, 2]
// 1이 3개, 2가 두개

    // 5
    // [2, 1, 1, 1]
    // [1, 2, 1, 1]
    // [1, 1, 1, 1, 1]
    // [1, 1, 2, 1]
    // [2, 2, 1]
    // [2, 1, 2]
    // [1, 2, 2]
    // [1, 1, 1, 2]
// 1이 5개, 2가 3개

  }
}
