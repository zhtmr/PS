package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1388 {
  static int N, M;
  static char[][] graph;
  static int MAX = 50 + 10;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new char[MAX][MAX];
    answer = 0;

    for (int i = 1; i <= N; i++) {
      String s = br.readLine();
      for (int j = 1; j <= M; j++) {
        graph[i][j] = s.charAt(j - 1);
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (graph[i][j] != 0) {
          dfs(i, j);
          answer++;
        }
      }
    }

    System.out.println(answer);
  }

  private static void dfs(int i, int j) {
    char cur = graph[i][j];
    graph[i][j] = 0;

    if (cur == '-' && graph[i][j + 1] == '-') {
      dfs(i, j + 1);
    } else if (cur == '|' && graph[i + 1][j] == '|') {
      dfs(i + 1, j);
    }
  }
}
