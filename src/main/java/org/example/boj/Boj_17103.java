package org.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_17103 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int T = scan.nextInt();
    boolean[] primeArr = sieve();
    for (int i = 0; i < T; i++) {
      int n = scan.nextInt();
      goldbachCnt(primeArr, n);
    }
    System.out.println(sb);
  }

  static boolean[] sieve() {
    boolean[] arr = new boolean[1000000 + 1];
    arr[0] = arr[1] = true;

    for (int i = 2; i * i <= 1000000; i++) {
      if (!arr[i]) {
        for (int j = i * i; j <= 1000000; j += i) {
          arr[j] = true;
        }
      }
    }
    return arr;
  }

  private static void goldbachCnt(boolean[] arr, int n) {
    int count = 0;
    for (int i = 2; i <= n / 2; i++) {
      // 인덱스가 확인하려는 숫자고 그 합이 n 이 나와야함
      // n = i + (n - i), i 가 n / 2 보다 클 수 없다. 그 숫자들이 소수인지 아닌지만 확인하면됨
      // 둘다 소수여야 골드바흐 통과함
      if (!arr[i] && !arr[n - i]) {
        count++;
      }
    }
    sb.append(count).append('\n');
  }



  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

}
