package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2667_2 {
  static int[][] graph;
  static boolean[][] visited;
  static int N;
  static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    graph = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    // (0,0) 부터 모든 요소에 대해 dfs
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && graph[i][j] == 1) {
          count = 1;
          bfs(i, j);
          result.add(count);
        }
      }
    }

    System.out.println(result.size());
    Collections.sort(result);
    for (Integer integer : result) {
      System.out.println(integer);
    }
  }

  private static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cx = current[0];
      int cy = current[1];

      // 상하좌우 탐색
      for (int i = 0; i < pos.length; i++) {
        int nx = cx + pos[i][0];
        int ny = cy + pos[i][1];

        if (isRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
          visited[nx][ny] = true;
          queue.offer(new int[] {nx, ny});
          count++;
        }
      }
    }
  }

  private static boolean isRange(int nx, int ny) {
    return nx >= 0 && nx < N && ny >= 0 && ny < N;
  }
}
