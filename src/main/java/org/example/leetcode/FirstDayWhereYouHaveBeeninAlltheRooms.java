package org.example.leetcode;

public class FirstDayWhereYouHaveBeeninAlltheRooms {
  public int firstDayBeenInAllRooms(int[] nextVisit) {
    // [0, 0, 2]
    // on day 0, visit room 0 => 1(odd), next visit : nextVisit[0] = 0
    // on day 1, visit room 0 => 2(even), next visit : (0 + 1) % 3 = 1      (0 -> 1)
    // on day 2, visit room 1 => 1(odd), next visit : nextVisit[1] = 0      (1 -> 0)
    // on day 3, visit room 0 => 3(odd), next visit : nextVisit[0] = 0
    // on day 4, visit room 0 => 4(even), next visit : (0 + 1) % 3 = 1
    // on day 5, visit room 1 => 2(even), next visit : (1 + 1) % 3 = 2
    // on day 6, visit room 2 => 1(odd), end

    // dp[i] : i 호실에 처음 도착한 날
    int n = nextVisit.length;
    long[] dp = new long[n];
    int mod = (int) 1e9 + 7;
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
      // dp[i] = 이전 방까지 걸린 시간 + 현재 방에 도착하는 시간 + 다시 돌아가는 시간
      dp[i] = (dp[i - 1] + 1 + dp[i - 1] - dp[nextVisit[i - 1]] + 1 + mod) % mod;
    }
    return (int) dp[n - 1];

  }

  public static void main(String[] args) {
    int i = new FirstDayWhereYouHaveBeeninAlltheRooms().firstDayBeenInAllRooms(new int[] {0, 0, 2});
    System.out.println("i = " + i);
  }
}
