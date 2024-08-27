package org.example.leetcode;

import java.util.*;

public class EvaluateDivision {
  static Map<String, Map<String, Double>> graph = new HashMap<>();

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    for (int i = 0; i < equations.size(); i++) {
      String dividend = equations.get(i).get(0);
      String divisor = equations.get(i).get(1);
      double quotient = values[i];

      graph.putIfAbsent(dividend, new HashMap<>());
      graph.putIfAbsent(divisor, new HashMap<>());
      graph.get(dividend).put(divisor, quotient);
      graph.get(divisor).put(dividend, 1.0 / quotient);
    }

    double[] results = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String dividend = queries.get(i).get(0);
      String divisor = queries.get(i).get(1);
      if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
        results[i] = -1.0;
      } else if (dividend.equals(divisor)) {
        results[i] = 1.0;
      } else {
        HashSet<String> visited = new HashSet<>();
        results[i] = dfs(dividend, divisor, visited);
      }
    }

    return results;
  }

  private double dfs(String start, String end, HashSet<String> visited) {
    if (start.equals(end)) {
      return 1.0;
    }
    visited.add(start);

    Map<String, Double> neighbors = graph.get(start);
    for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
      if (!visited.contains(entry.getKey())) {
        double v = dfs(entry.getKey(), end, visited);
        if (v != -1.0) {
          return v * entry.getValue();
        }
      }
    }

    return -1.0;
  }

  public static void main(String[] args) {
    EvaluateDivision eval = new EvaluateDivision();

    // 예시 데이터
    List<List<String>> equations = Arrays.asList(
        Arrays.asList("a", "b"),
        Arrays.asList("b", "c")
    );
    double[] values = {2.0, 3.0};
    List<List<String>> queries = Arrays.asList(
        Arrays.asList("a", "c"),
        Arrays.asList("b", "a"),
        Arrays.asList("a", "e"),
        Arrays.asList("a", "a"),
        Arrays.asList("x", "x")
    );

    double[] results = eval.calcEquation(equations, values, queries);
    System.out.println(Arrays.toString(results));
  }
}
