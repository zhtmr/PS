package org.example.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence_dp {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    int maxLen = 1;
    for(int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLen = Math.max(maxLen, dp[i]);
    }
    System.out.println("dp = " + Arrays.toString(dp));
    return maxLen;
  }

  public static void main(String[] args) {
    int i = new LongestIncreasingSubsequence_dp().lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3});
    System.out.println("i = " + i);
  }
}
