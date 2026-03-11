package 그래프;

import java.util.*;

// O(V + E)
public class BFS {
  public void solution(List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    bfs(0, graph, visited);
  }

  public void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
    // 시작 노드 예약
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      // 방문
      int cur = queue.poll();
      // 다음 노드 예약
      for (int next : graph.get(cur)) {
        if (!visited[next]) {
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
  }
  public static void main(String[] args) {
    
  }
}
