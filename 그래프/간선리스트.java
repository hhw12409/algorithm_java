package 그래프;

import java.util.*;


public class 간선리스트 {
  // 일방향 그래프
  public void solution() {
    int n = 5;
    int[][] edges = {
      {0, 1},
      {0, 2},
      {2, 0},
      {2, 4},
      {3, 1},
      {4, 0},
      {4, 2},
      {4, 3}
    };
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
    }
  }

  // 양방향 그래프
  public void solution2() {
    int n = 5;
    int[][] edges = {
      {0, 1},
      {0, 2},
      {2, 0},
      {2, 4},
      {3, 1},
      {4, 0},
      {4, 2},
      {4, 3}
    };
    List<List<Integer>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
  }
  public static void main(String[] args) {
    
  }
}
