package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p_169199 {
  static String[][] graph;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int x, y, n;

  public int solution(String[] board) {
    n = board.length;

    graph = new String[n][];
    visited = new boolean[n][];

    for (int i = 0; i < n; i++) {
      graph[i] = new String[board[i].length()];
      visited[i] = new boolean[board[i].length()];
      char[] charArray = board[i].toCharArray();
      for (int j = 0; j < charArray.length; j++) {
        String s = String.valueOf(charArray[j]);
        graph[i][j] = s;
        if (s.equals("R")) {
          x = i;
          y = j;
        }
      }
    }

    return bfs(x, y);
  }

  private int bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {x, y, 0});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cx = current[0];
      int cy = current[1];
      int dist = current[2];

      if (graph[cx][cy].equals("G")) {
        return dist;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cx;
        int ny = cy;

        while (isInRange(nx + dx[i], ny + dy[i]) && !graph[nx + dx[i]][ny + dy[i]].equals("D")) {
          nx += dx[i];
          ny += dy[i];
        }

        if (!visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new int[] {nx, ny, dist + 1});
        }
      }
    }
    return -1;
  }

  private boolean isInRange(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < graph[x].length;
  }

  public static void main(String[] args) {
    int solution = new p_169199().solution(
        new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
    System.out.println("solution = " + solution);
    int solution1 = new p_169199().solution(new String[] {".D.R", "....", ".G..", "...D"});
    System.out.println("solution1 = " + solution1);
  }
}
