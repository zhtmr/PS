package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p_1844 {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public int solution(int[][] maps) {
    graph = maps;
    visited = new boolean[graph.length][graph[0].length];

    return bfs();
  }

  private int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0, 1});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int depth = current[2];

      if (x == graph.length - 1 && y == graph[0].length - 1) {
        return depth;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (isInRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] != 0) {
          queue.add(new int[] {nx, ny, depth + 1});
          visited[nx][ny] = true;
        }
      }
    }
    return -1;
  }

  private static boolean isInRange(int x, int y) {
    return x >= 0 && x < graph.length && y >= 0 && y < graph[0].length;
  }


  public static void main(String[] args) {
    int solution = new p_1844().solution(
        new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}});

    System.out.println("solution = " + solution);


  }
}
