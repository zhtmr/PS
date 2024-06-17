package org.example;

import java.util.LinkedList;

public class DfsGraph {
  // 인접리스트
  private LinkedList<Integer>[] adjList;
  // 방문배열
  private boolean[] visited;

  public DfsGraph(int vertices) {
    this.adjList = new LinkedList[vertices];
    this.visited = new boolean[vertices];
    for (int i = 0; i < vertices; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int src, int dest) {
    adjList[src].add(dest);
  }

  private void dfs(int vertex) {
    visited[vertex] = true;
    System.out.println(vertex + " ");

    for (Integer next : adjList[vertex]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  public void dfsTraversal(int start) {
    dfs(start);
  }

  public static void main(String[] args) {
    DfsGraph graph = new DfsGraph(6);

    // 0 - 1,2
    // 1 - 3,4
    // 2 - 5
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);

    graph.dfsTraversal(0);
  }
}

