package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BfsGraph {
  public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
    ArrayList<String> visited = new ArrayList<>();
    ArrayList<String> needVisit = new ArrayList<>();

    needVisit.add(startNode);

    while (!needVisit.isEmpty()) {
      String node = needVisit.remove(0);

      if (!visited.contains(node)) {
        visited.add(node);
        needVisit.addAll(graph.get(node));
      }
    }
    return visited;
  }

  public static void main(String[] args) {
    // 그래프 생성
    HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

    graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
    graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
    graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
    graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
    graph.put("E", new ArrayList<String>(Arrays.asList("D")));
    graph.put("F", new ArrayList<String>(Arrays.asList("D")));
    graph.put("G", new ArrayList<String>(Arrays.asList("C")));
    graph.put("H", new ArrayList<String>(Arrays.asList("C")));
    graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
    graph.put("J", new ArrayList<String>(Arrays.asList("I")));


    BfsGraph bfsGraph = new BfsGraph();
    ArrayList<String> visited = bfsGraph.bfsFunc(graph, "A");
    System.out.println(visited);
  }


}
