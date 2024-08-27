package org.example.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence_bs {
  public int lengthOfLIS(int[] nums) {
    int[] lis = new int[nums.length];
    int length = 0;

    for (int num : nums) {
      int pos = Arrays.binarySearch(lis, 0, length, num);
      if (pos < 0) {
        pos = -(pos + 1);
      }
      lis[pos] = num;
      if (pos == length) {
        length++;
      }
    }
    System.out.println("lis = " + Arrays.toString(lis));
    return length;
  }

  public static void main(String[] args) {
    int i = new LongestIncreasingSubsequence_bs().lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3});
    System.out.println("i = " + i);
  }
}
