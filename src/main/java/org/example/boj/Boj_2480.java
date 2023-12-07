package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_2480 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    sameCount(a, b, c);

  }

  static void sameCount(int a, int b, int c) {

    List<Integer> list = Arrays.asList(a, b, c);

    int aCount = getCount(a, list);
    int bCount = getCount(b, list);
    int cCount = getCount(c, list);

    int maxCount = Math.max(Math.max(aCount, bCount), cCount);

    if (maxCount == 3) {
      System.out.println(10000 + a * 1000);
    } else if (maxCount == 2) {
      Integer target = extracted(list, maxCount).get(0);
      System.out.println(1000 + target * 100);
    } else {
      int max = Math.max(Math.max(a, b), c);
      System.out.println(max * 100);
    }

  }

  private static List<Integer> extracted(List<Integer> list, int maxCount) {
    return list.stream()
        .filter(e -> getCount(e, list) == maxCount)
        .collect(Collectors.toList());
  }

  private static int getCount(int a, List<Integer> list) {
    return (int) list.stream().filter(e -> e.equals(a)).count();
  }

}
